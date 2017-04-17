package org.jsack.tifsa.Database.OrderLineStatus;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by aaron on 4/17/17.
 */
public class OrderLineStatusWrapper implements RowMapper<OrderLineStatus> {
    @Override
    public OrderLineStatus mapRow(ResultSet rs, int rowNum) throws SQLException {
        OrderLineStatus orderLineStatus = new OrderLineStatus();

        orderLineStatus.setOrderLineStatusId(rs.getLong("OrderLineStatusID"));
        orderLineStatus.setOrderLineStatusDescription(rs.getString("OrderLineStatusDescription"));
        orderLineStatus.setDeleted(rs.getString("Deleted").equalsIgnoreCase("1"));

        return orderLineStatus;
    }
}
