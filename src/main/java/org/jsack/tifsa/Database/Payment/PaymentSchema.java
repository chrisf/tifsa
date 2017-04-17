package org.jsack.tifsa.Database.Payment;

import org.jsack.tifsa.Database.Interfaces.ISchema;
import org.springframework.jdbc.core.RowMapper;

/**
 * Created by aaron on 4/17/17.
 */
public class PaymentSchema implements ISchema {
    @Override
    public String getName() {
        return "Payment";
    }

    @Override
    public String getIdColumn() {
        return "PaymentID";
    }

    @Override
    public RowMapper getWrapper() {
        return new PaymentWrapper();
    }
}
