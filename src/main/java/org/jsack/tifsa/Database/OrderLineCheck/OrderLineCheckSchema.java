package org.jsack.tifsa.Database.OrderLineCheck;

import org.jsack.tifsa.Database.Interfaces.ISchema;
import org.springframework.jdbc.core.RowMapper;

/**
 * Created by aaron on 4/17/17.
 */
public class OrderLineCheckSchema implements ISchema {
    @Override
    public String getName() {
        return "OrderLineCheck";
    }

    @Override
    public String getIdColumn() {
        return "OrderLineCheckID";
    }

    @Override
    public RowMapper getWrapper() {
        return new OrderLineCheckWrapper();
    }
}
