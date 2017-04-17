package org.jsack.tifsa.Database.OrderStatusHistory;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by aaron on 4/17/17.
 */
public class OrderStatusHistoryWrapper implements RowMapper<OrderStatusHistory> {
    @Override
    public OrderStatusHistory mapRow(ResultSet rs, int rowNum) throws SQLException {
        OrderStatusHistory orderStatusHistory = new OrderStatusHistory();

        orderStatusHistory.setOrderStatusHistoryId(rs.getLong("OrderStatusHistoryID"));
        orderStatusHistory.setOrderStatusId(rs.getLong("OrderStatusID"));
        orderStatusHistory.setOrderId(rs.getLong("OrderID"));
        orderStatusHistory.setOrderStatusHistoryDate(rs.getTimestamp("OrderStatusHistoryDate"));
        orderStatusHistory.setOrderStatusHistoryEndDate(rs.getTimestamp("OrderStatusHistoryEndDate"));

        return orderStatusHistory;
    }
}
