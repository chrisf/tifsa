package org.jsack.tifsa.Database.Payment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by aaron on 4/17/17.
 */
public class PaymentWrapper implements RowMapper<Payment> {
    @Override
    public Payment mapRow(ResultSet rs, int rowNum) throws SQLException {
        Payment payment = new Payment();

        payment.setPaymentId(rs.getLong("PaymentID"));
        payment.setPaymentTypeId(rs.getLong("PaymentTypeID"));
        payment.setPaymentAmount(rs.getDouble("PaymentAmount"));
        payment.setPaymentDate(rs.getTimestamp("PaymentDate"));
        payment.setDeleted(rs.getString("Deleted").equalsIgnoreCase("1"));

        return payment;
    }
}
