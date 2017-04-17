package org.jsack.tifsa.Database.PaymentType;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by aaron on 4/17/17.
 */
public class PaymentTypeWrapper implements RowMapper<PaymentType> {
    @Override
    public PaymentType mapRow(ResultSet rs, int rowNum) throws SQLException {
        PaymentType paymentType = new PaymentType();

        paymentType.setPaymentTypeId(rs.getLong("PaymentTypeID"));
        paymentType.setPaymentTypeDescription(rs.getString("PaymentTypeDescription"));
        paymentType.setDeleted(rs.getString("Deleted").equalsIgnoreCase("1"));

        return paymentType;
    }
}
