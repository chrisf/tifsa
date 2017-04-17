package org.jsack.tifsa.Database.OrderLine;

import org.jsack.tifsa.Database.Interfaces.ISchema;
import org.springframework.jdbc.core.RowMapper;

/**
 * Created by aaron on 4/17/17.
 */
public class OrderLineSchema implements ISchema {
    @Override
    public String getName() {
        return "OrderLine";

    }

    @Override
    public String getIdColumn() {
        return "OrderLineID";
    }

    @Override
    public RowMapper getWrapper() {
        return new OrderLineWrapper();
    }
}
