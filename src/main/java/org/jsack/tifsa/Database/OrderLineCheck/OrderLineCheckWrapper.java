package org.jsack.tifsa.Database.OrderLineCheck;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by aaron on 4/17/17.
 */
public class OrderLineCheckWrapper implements RowMapper<OrderLineCheck> {
    @Override
    public OrderLineCheck mapRow(ResultSet rs, int rowNum) throws SQLException {
        OrderLineCheck orderLineCheck = new OrderLineCheck();

        orderLineCheck.setOrderLineCheckId(rs.getLong("OrderLineCheckID"));
        orderLineCheck.setOrderLineId(rs.getLong("OrderLineID"));
        orderLineCheck.setEmployeeId(rs.getLong("EmployeeID"));
        orderLineCheck.setOrderLineCheck(rs.getString("OrderLineCheck"));
        orderLineCheck.setOrderLineCheckDate(rs.getTimestamp("OrderLineCheckDate"));
        orderLineCheck.setDeleted(rs.getString("Deleted").equalsIgnoreCase("1"));

        return orderLineCheck;
    }
}
