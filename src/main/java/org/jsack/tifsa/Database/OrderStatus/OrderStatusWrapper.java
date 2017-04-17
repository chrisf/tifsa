package org.jsack.tifsa.Database.OrderStatus;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by aaron on 4/17/17.
 */
public class OrderStatusWrapper implements RowMapper<OrderStatus> {
    @Override
    public OrderStatus mapRow(ResultSet rs, int rowNum) throws SQLException {
        OrderStatus orderStatus = new OrderStatus();

        orderStatus.setOrderStatusId(rs.getLong("OrderStatusID"));
        orderStatus.setOrderStatusDescription(rs.getString("OrderStatusDescription"));
        orderStatus.setDeleted(rs.getString("Deleted").equalsIgnoreCase("1"));

        return orderStatus;
    }
}
