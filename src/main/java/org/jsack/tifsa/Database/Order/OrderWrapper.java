package org.jsack.tifsa.Database.Order;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by aaron on 4/3/17.
 */
public class OrderWrapper implements org.springframework.jdbc.core.RowMapper<Order> {
    @Override
    public Order mapRow(ResultSet resultSet, int i) throws SQLException {
        Order order = new Order();
        order.setOrderId(resultSet.getLong("OrderID"));
        order.setCustomerId(resultSet.getLong("CustomerID"));
        order.setOrderTotal(resultSet.getDouble("OrderTotal"));
        order.setOrderDate(resultSet.getTimestamp("OrderDate"));
        order.setOrderBillingFirst(resultSet.getString("OrderBillingFirst"));
        order.setOrderBillingLast(resultSet.getString("OrderBillingLast"));
        order.setOrderBillingStreet(resultSet.getString("OrderBillingStreet"));
        order.setOrderBillingStreet2(resultSet.getString("OrderBillingStreet2"));
        order.setOrderBillingState(resultSet.getLong("OrderBillingState"));
        order.setOrderBillingCity(resultSet.getString("OrderBillingCity"));
        order.setOrderBillingZip(resultSet.getString("OrderBillingZip"));
        order.setOrderPaid(resultSet.getDouble("OrderPaid"));
        order.setOrderbalance(resultSet.getDouble("OrderBalance"));
        order.setOrderCashOnDelivery(resultSet.getString("OrderCashOnDelivery"));
        order.setOrderStatusId(resultSet.getLong("OrderStatusID"));
        order.setOrderStatusDate(resultSet.getTimestamp("OrderStatusDate"));
        order.setOrderTax(resultSet.getDouble("OrderTax"));
        order.setOrderFee(resultSet.getDouble("OrderFee"));
        order.setSoldByEmployeeId(resultSet.getLong("SoldByEmployeeID"));
        order.setOrderCompletedOn(resultSet.getTimestamp("OrderCompletedOn"));
        order.setOrderShippingStreet(resultSet.getString("OrderShippingStreet"));
        order.setOrderShippingStreet2(resultSet.getString("OrderShippingStreet2"));
        order.setOrderShippingState(resultSet.getLong("OrderShippingState"));
        order.setOrderShippingCity(resultSet.getString("OrderShippingCity"));
        order.setOrderShippingZip(resultSet.getString("OrderShippingZip"));
        order.setDeleted(resultSet.getString("Deleted").equalsIgnoreCase("1"));

        return order;
    }
}
