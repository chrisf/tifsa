package org.jsack.tifsa.Database.OrderLineDeliveryType;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by aaron on 4/17/17.
 */
public class OrderLineDeliveryTypeWrapper implements RowMapper<OrderLineDeliveryType> {
    @Override
    public OrderLineDeliveryType mapRow(ResultSet rs, int rowNum) throws SQLException {
        OrderLineDeliveryType orderLineDeliveryType = new OrderLineDeliveryType();

        orderLineDeliveryType.setOrderLineDeliveryTypeID(rs.getLong("OrderLineDeliveryTypeID"));
        orderLineDeliveryType.setOrderLineDeliveryTypeDescription(rs.getString("OrderLineDeliveryTypeDescription"));
        orderLineDeliveryType.setDeleted(rs.getString("Deleted").equalsIgnoreCase("1"));

        return orderLineDeliveryType;
    }
}
