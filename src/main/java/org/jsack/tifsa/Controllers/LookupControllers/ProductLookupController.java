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
import javafx.scene.control.TreeTableColumn;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.jsack.tifsa.Cache;
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
@ViewController("/Scenes/Lookup/LookupProduct.fxml")
public class ProductLookupController {
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

    private ObservableList<ProductReportItem> products;
    @PostConstruct
    public void init() {
        setupCellValueFactory(productSkuColumn, e -> e.sku);
        setupCellValueFactory(productNameColumn, e -> e.name);
        setupCellValueFactory(productBrandColumn, e -> e.brand);
        setupCellValueFactory(productPriceColumn, e -> e.price);

        filterText.textProperty().addListener((o, oldVal, newVal) -> {
            new Thread(() -> {
               productTable.setPredicate(productProp -> {
                 final ProductReportItem product = productProp.getValue();

                 return  Utility.containsIgnoreCase(product.name.get(), newVal)||
                         Utility.containsIgnoreCase(product.brand.get(), newVal) || Utility.containsIgnoreCase(product.sku.get(),newVal);
               });
            }).start();
        });
        productTable.getSelectionModel().selectedItemProperty().addListener(
                ((observable, oldValue, newValue) -> {
                    byte[] imageData = newValue.getValue().imageData;
                    if(imageData != null) {
                        try {
                            javafx.scene.image.Image prodImage = new Image(new ByteArrayInputStream(imageData));
                            productView.setFitWidth(150);
                            productView.setFitHeight(150);
                            productView.setImage(prodImage);
                        } catch( Exception ex ) { }
                   }
                   else {
                        productView.setImage(null);
                    }
                })
        );
        refresh.setOnMouseClicked(e -> {
           new Thread(() -> {
               updateProducts();
            }).start();
        });
        new Thread(() -> { updateProducts(); }).start();
    }
    private void updateProducts() {
        List<ProductReportItem> newItems = Cache.getJdbcTemplate().query("SELECT ProductSKU, ProductDescription, ProductPrice, BrandName, PictureData " +
                "FROM Product " +
                "INNER JOIN Brand ON Product.BrandID = Brand.BrandID "+
                "FULL JOIN Picture ON Picture.ProductID = Product.ProductID"
                ,new ProductReportItemWrapper());
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
           this.sku = sku != null ?  new SimpleStringProperty(sku) : new SimpleStringProperty("");
           this.name = name != null ? new SimpleStringProperty(name): new SimpleStringProperty("");
           this.brand = brand != null ?  new SimpleStringProperty(brand) : new SimpleStringProperty("");
           this.price = price != null ? new SimpleDoubleProperty(price) : new SimpleDoubleProperty(0.0);
           this.imageData = imageData;
       }
    }
}
