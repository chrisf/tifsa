package org.jsack.tifsa.Database.OrderLine;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by aaron on 4/17/17.
 */
public class OrderLineWrapper implements RowMapper<OrderLine> {
    @Override
    public OrderLine mapRow(ResultSet rs, int rowNum) throws SQLException {
        OrderLine orderLine = new OrderLine();

        orderLine.setOrderLineId(rs.getLong("OrderLineID"));
        orderLine.setOrderId(rs.getLong("OrderID"));
        orderLine.setProductId(rs.getLong("ProductID"));
        orderLine.setOrderLineQuantity(rs.getLong("OrderLineQuantity"));
        orderLine.setOrderLineDiscount(rs.getDouble("OrderLineDiscount"));
        orderLine.setOrderLineRecieved(rs.getTimestamp("OrderLineRecieved"));
        orderLine.setOrderLineDelivered(rs.getTimestamp("OrderLineDelivered"));
        orderLine.setOrderLineDeliverOn(rs.getTimestamp("OrderLineDeliverOn"));
        orderLine.setOrderLineDeliveryTypeId(rs.getLong("OrderLineDeliveryTypeID"));
        orderLine.setOrderLineStatusId(rs.getLong("OrderLineStatusID"));
        orderLine.setDeleted(rs.getString("Deleted").equalsIgnoreCase("1"));

        return orderLine;

    }
}
