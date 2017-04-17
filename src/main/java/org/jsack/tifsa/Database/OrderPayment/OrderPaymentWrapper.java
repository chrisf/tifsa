package org.jsack.tifsa.Database.OrderPayment;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by aaron on 4/17/17.
 */
public class OrderPaymentWrapper implements RowMapper<OrderPayment> {
    @Override
    public OrderPayment mapRow(ResultSet rs, int rowNum) throws SQLException {
        OrderPayment orderPayment = new OrderPayment();

        orderPayment.setPaymentId(rs.getLong("PaymentID"));
        orderPayment.setOrderId(rs.getLong("OrderID"));
        orderPayment.setOrderPaymentAmount(rs.getDouble("OrderPaymentAmount"));
        orderPayment.setDeleted(rs.getString("Deleted").equalsIgnoreCase("1"));

        return orderPayment;
    }
}
