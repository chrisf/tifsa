package org.jsack.tifsa.Database.Order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by aaron on 4/3/17.
 */
public class OrderDAO extends OrderBase {
    public OrderDAO() {
        this.setTableName("Order");
        this.setSimpleInsert(this.getTableName(), "OrderID");
    }
    @Override
    public List<Order> selectAll() {
        String sql = "SELECT * FROM Order";
        return getTemplate().query(sql, new Object[] { this.getTableName() }, new OrderWrapper());
    }

    @Override
    public Order selectById(long id) {
        String sql = "SELECT * FROM ? WHERE OrderID = ?";
        return getTemplate().queryForObject(sql, new Object[] { this.getTableName(), id }, new OrderWrapper());
    }

    @Override
    public long create(Order c) {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("OrderTotal", c.getOrdertotal());
        attributes.put("OrderDate", c.getOrderdate());
        attributes.put("OrderBillingFirst", c.getOrderbillingfirst());
        attributes.put("OrderBillingLast", c.getOrderbillinglast());
        attributes.put("OrderBillingStreet", c.getOrderbillingstreet());
        attributes.put("OrderBillingStreet2", c.getOrderbillingstreet2());
        attributes.put("OrderBillingState", c.getOrderbillingstate());
        attributes.put("OrderBillingCity", c.getOrderbillingcity());
        attributes.put("OrderBillingZip", c.getOrderbillingzip());
        attributes.put("OrderPaid", c.getOrderpaid());
        attributes.put("OrderBalance", c.getOrderbalance());
        attributes.put("OrderCashOnDelivery", c.getOrdercashondelivery());
        attributes.put("OrderStatusID", c.getOrderstatusid());
        attributes.put("OrderStatusDate", c.getOrderstatusdate());
        attributes.put("OrderTax", c.getOrdertax());
        attributes.put("OrderFee", c.getOrderfee());
        attributes.put("SoldByEmployeeID", c.getSoldbyemployeeid());
        attributes.put("OrderCompletedOn", c.getOrdercompletedon());
        attributes.put("OrderShippingStreet", c.getOrdershippingstreet());
        attributes.put("OrderShippingStreet2", c.getOrdershippingstreet2());
        attributes.put("OrderShippingState", c.getOrdershippingstate());
        attributes.put("OrderShippingCity", c.getOrdershippingcity());
        attributes.put("OrderShippingZip", c.getOrdershippingzip());
        
        return getSimpleInsert().executeAndReturnKey(attributes).longValue();
    }

    public int delete(long id) {
        return 0;
    }

    @Override
    public int update(Order c) {
        return 0;
    }
}
