package org.jsack.tifsa.Controllers.LookupControllers;

import com.jfoenix.controls.*;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import io.datafx.controller.ViewController;
import io.datafx.controller.flow.context.FXMLViewFlowContext;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import jdk.internal.org.objectweb.asm.tree.JumpInsnNode;
import org.jsack.tifsa.Database.DBSelect;
import org.jsack.tifsa.Database.Order.Order;
import org.jsack.tifsa.Database.Order.OrderSchema;
import org.jsack.tifsa.Julius;
import org.jsack.tifsa.Utility;
import org.springframework.jdbc.core.RowMapper;

import javax.annotation.PostConstruct;
import java.io.ByteArrayInputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.function.Function;

/**
 * Created by Admin on 4/19/2017.
 */
@ViewController("/Scenes/Lookup/LookupOrder2.fxml")
public class OrderLookup2 {

    @FXML
    JFXTextField filterText;

    @FXML
    ImageView productView;

    @FXML
    JFXTreeTableView<ProductReportItem> productTable;

    @FXML
    JFXButton refresh;

    @FXML
    JFXTreeTableColumn<ProductReportItem, String> productSkuColumn;

    @FXML
    JFXTreeTableColumn<ProductReportItem, String> productNameColumn;

    @FXML
    JFXTreeTableColumn<ProductReportItem, String> productBrandColumn;

    @FXML
    JFXTreeTableColumn<ProductReportItem, Number> productPriceColumn;


    @FXMLViewFlowContext
    ViewFlowContext context;

    @FXML
    Label customerName, orderTotal;

    private ObservableList<ProductReportItem> products;
    private long orderId = 174;

    @PostConstruct
    public void init() {
        setupCellValueFactory(productSkuColumn, e -> e.sku);
        setupCellValueFactory(productNameColumn, e -> e.name);
        setupCellValueFactory(productBrandColumn, e -> e.brand);
        setupCellValueFactory(productPriceColumn, e -> e.price);

        orderId = (long) context.getRegisteredObject("OrderLookupId");
        Order o1 = (Order)Julius.getJdbcTemplate().queryForObject("SELECT * FROM [Order] WHERE OrderID = ?", new Object[] { orderId }, new OrderSchema().getWrapper());

        customerName.setText("Name: " + o1.getOrderBillingFirst() + " " + o1.getOrderBillingLast());
        orderTotal.setText("Total: " + o1.getOrderTotal().toString());

        productTable.getSelectionModel().selectedItemProperty().addListener(
                ((observable, oldValue, newValue) -> {
                    byte[] imageData = newValue.getValue().imageData;
                    if(imageData != null) {
                        try {
                            javafx.scene.image.Image prodImage = new Image(new ByteArrayInputStream(imageData));
                            productView.setFitWidth(250);
                            productView.setFitHeight(250);
                            productView.setImage(prodImage);
                        } catch( Exception ex ) { }
                    }
                    else {
                        productView.setImage(null);
                    }
                })
        );
        new Thread( () ->{
            orderId = (long) context.getRegisteredObject("OrderLookupId");
            updateProducts();
        }).start();
    }
    private void updateProducts() {
        List<ProductReportItem> newItems = Julius.getJdbcTemplate().query("SELECT ProductSKU, ProductDescription, ProductPrice, BrandName, PictureData  " +
                        "FROM Product " +
                        "INNER JOIN ( SELECT * FROM OrderLine WHERE OrderID = ?) as o1 ON Product.ProductID = o1.ProductID " +
                        "INNER JOIN Brand ON Product.BrandID = Brand.BrandID " +
                        "LEFT JOIN Picture ON Picture.ProductID = Product.ProductID",
                new Object[] { orderId } , new ProductReportItemWrapper());
        products = FXCollections.observableArrayList(newItems);
        Utility.runOnGuiAndWait(() -> {
            productTable.setRoot(new RecursiveTreeItem<>(products, RecursiveTreeObject::getChildren));
            productTable.setShowRoot(false);
        });
    }
    private <T> void setupCellValueFactory(JFXTreeTableColumn<ProductReportItem, T> column, Function<ProductReportItem, ObservableValue<T>> mapper) {
        column.setCellValueFactory((TreeTableColumn.CellDataFeatures<ProductReportItem, T> param) -> {
            if (column.validateValue(param)) {
                return mapper.apply(param.getValue().getValue());
            } else {
                return column.getComputedValue(param);
            }
        });
    }
    private class ProductReportItemWrapper implements RowMapper<ProductReportItem> {
        @Override
        public ProductReportItem mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new ProductReportItem(rs.getString("ProductSKU"), rs.getString("ProductDescription"),
                    rs.getString("BrandName"), rs.getDouble("ProductPrice"), rs.getBytes("PictureData"));

        }
    }

    static final class ProductReportItem extends RecursiveTreeObject<ProductReportItem> {
        final StringProperty sku;
        final StringProperty name;
        final StringProperty brand;
        final DoubleProperty price;
        final byte[] imageData;

        ProductReportItem(String sku, String name, String brand, Double price, byte[] imageData) {
            this.sku = sku != null ? new SimpleStringProperty(sku) : new SimpleStringProperty("");
            this.name = name != null ? new SimpleStringProperty(name) : new SimpleStringProperty("");
            this.brand = brand != null ? new SimpleStringProperty(brand) : new SimpleStringProperty("");
            this.price = price != null ? new SimpleDoubleProperty(price) : new SimpleDoubleProperty(0.0);
            this.imageData = imageData;
        }
    }
}
