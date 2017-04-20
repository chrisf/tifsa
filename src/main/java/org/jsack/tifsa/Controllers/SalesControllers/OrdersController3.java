package org.jsack.tifsa.Controllers.SalesControllers;

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
import javafx.scene.text.Text;
import org.jsack.tifsa.Database.Order.Order;
import org.jsack.tifsa.Julius;
import org.jsack.tifsa.Reports.ColumnFormats.CurrencyColumn;
import org.jsack.tifsa.Utility;
import org.springframework.jdbc.core.RowMapper;

import javax.annotation.PostConstruct;
import java.io.ByteArrayInputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Admin on 4/19/2017.
 */
@ViewController("/Scenes/Sales/OrderForm3.fxml")
public class OrdersController3 {
    @FXML
    JFXTextField filterText;

    @FXML
    ImageView productView;

    @FXML
    JFXTreeTableView<ProductReportItem> productTable, orderTable;

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


    @FXML
    JFXTreeTableColumn<ProductReportItem, String> orderSkuColumn;

    @FXML
    JFXTreeTableColumn<ProductReportItem, String> orderNameColumn;

    @FXML
    JFXTreeTableColumn<ProductReportItem, String> orderBrandColumn;

    @FXML
    JFXTreeTableColumn<ProductReportItem, Number> orderPriceColumn;

    @FXML
    JFXButton addButton;

    @FXML
    JFXButton createOrderButton;

    @FXML
    Text subTotal;

    @FXML
    Text deliveryFee;

    @FXML
    Text tax;

    @FXML
    Text invoiceTotal;

    Order order;
    boolean isDelivery = false;

    @FXMLViewFlowContext
    ViewFlowContext context;

    private ObservableList<ProductReportItem> products, orderProducts;
    @PostConstruct
    public void init() {
        order = (Order) context.getRegisteredObject("NewOrderCustomer");
        isDelivery = (Boolean) context.getRegisteredObject("NewOrderIsDelivery");

        orderProducts = FXCollections.observableArrayList();

        orderTable.setRoot(new RecursiveTreeItem<>(orderProducts, RecursiveTreeObject::getChildren));
        orderTable.setShowRoot(false);;

        setupCellValueFactory(orderSkuColumn, e -> e.sku);
        setupCellValueFactory(orderNameColumn, e -> e.name);
        setupCellValueFactory(orderBrandColumn, e -> e.brand);
        setupCellValueFactory(orderPriceColumn, e -> e.price);


        setupCellValueFactory(productSkuColumn, e -> e.sku);
        setupCellValueFactory(productNameColumn, e -> e.name);
        setupCellValueFactory(productBrandColumn, e -> e.brand);
        setupCellValueFactory(productPriceColumn, e -> e.price);

        setTotals();

        createOrderButton.setOnMouseClicked(e -> {
            insertOrder();
        });

        addButton.setOnMouseClicked(e -> {
            orderProducts.add(productTable.getSelectionModel().getSelectedItem().getValue());

            setTotals();
        });

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
                    if(newValue == null) {
                        return;
                    }

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

    private void setTotals() {
        List<Double> prices = orderProducts.stream()
                .map(ProductReportItem::getPrice)
                .collect(Collectors.toList());

        double deliveryFeeValue = isDelivery ? 119.95 : 0;
        double orderTotal = Utility.calculateOrderTotal(prices) + deliveryFeeValue;
        double orderSubTotal = Utility.calculateOrderSubTotal(prices);
        double orderTax = Utility.calculateOrderTax(orderSubTotal);

        CurrencyColumn orderTotalFormatted = new CurrencyColumn(String.valueOf(orderTotal));
        CurrencyColumn orderSubTotalFormatted = new CurrencyColumn(String.valueOf(orderSubTotal));
        CurrencyColumn orderTaxFormatted = new CurrencyColumn(String.valueOf(orderTax));
        CurrencyColumn deliveryFeeFormatted = new CurrencyColumn(String.valueOf(deliveryFeeValue));


        subTotal.setText(orderSubTotalFormatted.getValue());
        deliveryFee.setText(deliveryFeeFormatted.getValue());
        tax.setText(orderTaxFormatted.getValue());
        invoiceTotal.setText(orderTotalFormatted.getValue());
    }

    private void updateProducts() {
        List<ProductReportItem> newItems = Julius.getJdbcTemplate().query("SELECT ProductSKU, ProductDescription, ProductPrice, BrandName, PictureData " +
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

    private void insertOrder() {
        HashMap<String, Object> attributes = new HashMap<>();

        String sql = "INSERT INTO [Order] (\n" +
                "  CustomerID BIGINT,\n" +
                "  OrderBillingFirst,\n" +
                "  OrderBillingLast,\n" +
                "  OrderBillingStreet,\n" +
                "  OrderBillingStreet2,\n" +
                "  OrderBillingState,\n" +
                "  OrderBillingCity,\n" +
                "  OrderBillingZip,\n" +
                "  OrderCashOnDelivery,\n" +
                "  SoldByEmployeeID,\n" +
                "  OrderShippingStreet,\n" +
                "  OrderShippingStreet2,\n" +
                "  OrderShippingState,\n" +
                "  OrderShippingCity,\n" +
                "  OrderShippingZip\n" +
                ") VALUES(" +
                ":customerId, :orderBillingFirst, :orderBillingLast, :orderBillingStreet, :orderBillingStreet2, " +
                ":orderBillingState, :orderBillingCity, :orderBillingZip, :orderCashOnDelivery, :soldByEmployeeId, " +
                ":orderShippingStreet, :orderShippingStreet2, :orderShippingState, :orderShippingCity, :orderShippingZip);";

        attributes.put(":customerId", order.getCustomerId());
        attributes.put(":orderBillingFirst", order.getOrderBillingFirst());
        attributes.put(":orderBillingLast", order.getOrderBillingLast());
        attributes.put(":orderBillingStreet", order.getOrderBillingStreet());
        attributes.put(":orderBillingStreet2", order.getOrderBillingStreet2());
        attributes.put(":orderBillingState", order.getOrderBillingState());
        attributes.put(":orderBillingCity", order.getOrderBillingCity());
        attributes.put(":orderBillingZip", order.getOrderBillingZip());
        attributes.put(":orderCashOnDelivery", order.getOrderCashOnDelivery());
        attributes.put(":soldByEmployeeId", order.getSoldByEmployeeId());
        attributes.put(":orderShippingStreet", order.getOrderShippingStreet());
        attributes.put(":orderShippingStreet2", order.getOrderShippingStreet2());
        attributes.put(":orderShippingState", order.getOrderShippingState());
        attributes.put(":orderShippingCity", order.getOrderShippingCity());
        attributes.put(":orderShippingZip", order.getOrderShippingZip());

        Julius.runQuery(sql, attributes);
    }

    private void insertOrderLines() {
//        HashMap<String, Object> attributes = new HashMap<>();
//
//
//        String sql = "INSERT INTO OrderLine";
//
//
//        attributes.put()
//
//        Julius.runQuery(sql, attributes);
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

       public double getPrice() { return price.get(); }
    }
}
