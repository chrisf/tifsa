package org.jsack.tifsa.Database.PaymentType;

import org.jsack.tifsa.Database.Interfaces.ISchema;
import org.springframework.jdbc.core.RowMapper;

/**
 * Created by aaron on 4/17/17.
 */
public class PaymentTypeSchema implements ISchema {
    @Override
    public String getName() {
        return "PaymentType";
    }

    @Override
    public String getIdColumn() {
        return "PaymentTypeID";
    }

    @Override
    public RowMapper getWrapper() {
        return new PaymentTypeWrapper();
    }
}
