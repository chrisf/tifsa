package org.jsack.tifsa.Controllers.LookupControllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import io.datafx.controller.ViewController;
import io.datafx.controller.flow.context.FXMLViewFlowContext;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import org.springframework.jdbc.core.RowMapper;

import javax.annotation.PostConstruct;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    JFXTreeTableView productTable;

    @FXML
    JFXButton refresh;

    @FXML
    JFXTreeTableColumn productSkuColumn, productNameColumn, productPriceColumn, productBrandColumn;


    @FXMLViewFlowContext
    ViewFlowContext context;

    private ObservableList<ProductReportItem> products;

    @PostConstruct
    public void init() {
        

    }

    private class ProductReportItemWrapper implements RowMapper<ProductReportItem> {
        @Override
        public ProductReportItem mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new ProductReportItem(rs.getString("ProductSKU"), rs.getString("ProductDescription"), rs.getString("BrandName") rs.getDouble("ProductPrice"));
        }
    }
    private static final class ProductReportItem extends RecursiveTreeObject<ProductReportItem> {
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
