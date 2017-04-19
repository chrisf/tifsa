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
import javafx.scene.image.ImageView;
import org.jsack.tifsa.Database.DBSelect;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.RowMapper;

import javax.annotation.PostConstruct;
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

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        DBSelect dbSelector = (DBSelect) applicationContext.getBean("dbSelect");
        List<ProductReportItem> newItems = dbSelector.getTemplate().query("SELECT ProductSKU, ProductDescription, ProductPrice, BrandName FROM Product INNER JOIN Brand ON Product.BrandID = Brand.BrandID;", new ProductReportItemWrapper());
        System.out.println(newItems);
        products = FXCollections.observableArrayList(newItems);
        productTable.setRoot(new RecursiveTreeItem<>(products, RecursiveTreeObject::getChildren));
        productTable.setShowRoot(false);

        filterText.textProperty().addListener(
                (observable, oldValue, newValue) -> productTable.setPredicate(
                        product -> {
                            final ProductReportItem p = product.getValue();
                            return p.sku.get().contains(newValue) ||
                                    p.name.get().contains(newValue) ||
                                    p.brand.get().contains(newValue);
                        }
                )
        );
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
            return new ProductReportItem(rs.getString("ProductSKU"), rs.getString("ProductDescription"), rs.getString("BrandName"), rs.getDouble("ProductPrice"));
        }
    }
    static final class ProductReportItem extends RecursiveTreeObject<ProductReportItem> {
       final StringProperty sku;
       final StringProperty name;
       final StringProperty brand;
       final DoubleProperty price;

       ProductReportItem(String sku, String name, String brand, Double price) {
           this.sku = new SimpleStringProperty(sku);
           this.name = new SimpleStringProperty(name);
           this.brand = new SimpleStringProperty(brand);
           this.price = new SimpleDoubleProperty(price);
       }
    }
}
