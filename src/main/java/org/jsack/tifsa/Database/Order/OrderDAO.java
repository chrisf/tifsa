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
        attributes.put("OrderTotal", c.getOrderTotal());
        attributes.put("OrderDate", c.getOrderDate());
        attributes.put("OrderBillingFirst", c.getOrderBillingFirst());
        attributes.put("OrderBillingLast", c.getOrderBillingLast());
        attributes.put("OrderBillingStreet", c.getOrderBillingStreet());
        attributes.put("OrderBillingStreet2", c.getOrderBillingStreet2());
        attributes.put("OrderBillingState", c.getOrderBillingState());
        attributes.put("OrderBillingCity", c.getOrderBillingCity());
        attributes.put("OrderBillingZip", c.getOrderBillingZip());
        attributes.put("OrderPaid", c.getOrderPaid());
        attributes.put("OrderBalance", c.getOrderbalance());
        attributes.put("OrderCashOnDelivery", c.getOrderCashOnDelivery());
        attributes.put("OrderStatusID", c.getOrderStatusId());
        attributes.put("OrderStatusDate", c.getOrderStatusDate());
        attributes.put("OrderTax", c.getOrderTax());
        attributes.put("OrderFee", c.getOrderFee());
        attributes.put("SoldByEmployeeID", c.getSoldByEmployeeId());
        attributes.put("OrderCompletedOn", c.getOrderCompletedOn());
        attributes.put("OrderShippingStreet", c.getOrderShippingStreet());
        attributes.put("OrderShippingStreet2", c.getOrderShippingStreet2());
        attributes.put("OrderShippingState", c.getOrderShippingState());
        attributes.put("OrderShippingCity", c.getOrderShippingCity());
        attributes.put("OrderShippingZip", c.getOrderShippingZip());
        
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
