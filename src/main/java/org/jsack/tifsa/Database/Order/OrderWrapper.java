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
        order.setOrderid(resultSet.getLong("OrderID"));
        order.setCustomerid(resultSet.getLong("CustomerID"));
        order.setOrdertotal(resultSet.getDouble("OrderTotal"));
        order.setOrderdate(resultSet.getTimestamp("OrderDate"));
        order.setOrderbillingfirst(resultSet.getString("OrderBillingFirst"));
        order.setOrderbillinglast(resultSet.getString("OrderBillingLast"));
        order.setOrderbillingstreet(resultSet.getString("OrderBillingStreet"));
        order.setOrderbillingstreet2(resultSet.getString("OrderBillingStreet2"));
        order.setOrderbillingstate(resultSet.getLong("OrderBillingState"));
        order.setOrderbillingcity(resultSet.getString("OrderBillingCity"));
        order.setOrderbillingzip(resultSet.getString("OrderBillingZip"));
        order.setOrderpaid(resultSet.getDouble("OrderPaid"));
        order.setOrderbalance(resultSet.getDouble("OrderBalance"));
        order.setOrdercashondelivery(resultSet.getString("OrderCashOnDelivery"));
        order.setOrderstatusid(resultSet.getLong("OrderStatusID"));
        order.setOrderstatusdate(resultSet.getTimestamp("OrderStatusDate"));
        order.setOrdertax(resultSet.getDouble("OrderTax"));
        order.setOrderfee(resultSet.getDouble("OrderFee"));
        order.setSoldbyemployeeid(resultSet.getLong("SoldByEmployeeID"));
        order.setOrdercompletedon(resultSet.getTimestamp("OrderCompletedOn"));
        order.setOrdershippingstreet(resultSet.getString("OrderShippingStreet"));
        order.setOrdershippingstreet2(resultSet.getString("OrderShippingStreet2"));
        order.setOrdershippingstate(resultSet.getLong("OrderShippingState"));
        order.setOrdershippingcity(resultSet.getString("OrderShippingCity"));
        order.setOrdershippingzip(resultSet.getString("OrderShippingZip"));
        return order;
    }
}
