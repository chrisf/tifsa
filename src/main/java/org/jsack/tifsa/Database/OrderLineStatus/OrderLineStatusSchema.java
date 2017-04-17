package org.jsack.tifsa.Database.OrderLineStatus;

import org.jsack.tifsa.Database.Interfaces.ISchema;
import org.springframework.jdbc.core.RowMapper;

/**
 * Created by aaron on 4/17/17.
 */
public class OrderLineStatusSchema implements ISchema {
    @Override
    public String getName() {
        return "OrderLineStatus";
    }

    @Override
    public String getIdColumn() {
        return "OrderLineStatusID";
    }

    @Override
    public RowMapper getWrapper() {
        return new OrderLineStatusWrapper();
    }
}
