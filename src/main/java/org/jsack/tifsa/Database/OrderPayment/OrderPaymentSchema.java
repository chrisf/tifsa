package org.jsack.tifsa.Database.OrderPayment;

import org.jsack.tifsa.Database.Interfaces.ISchema;
import org.springframework.jdbc.core.RowMapper;

/**
 * Created by aaron on 4/17/17.
 */
public class OrderPaymentSchema implements ISchema {
    @Override
    public String getName() {
        return "OrderPayment";
    }

    @Override
    public String getIdColumn() {
        return "OrderPaymentID";
    }

    @Override
    public RowMapper getWrapper() {
        return new OrderPaymentWrapper();
    }
}
