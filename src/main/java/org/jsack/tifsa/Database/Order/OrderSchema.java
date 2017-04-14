package org.jsack.tifsa.Database.Order;

import org.jsack.tifsa.Database.Interfaces.ISchema;
import org.springframework.jdbc.core.RowMapper;

/**
 * Created by aaron on 4/13/17.
 */
public class OrderSchema implements ISchema {
    @Override
    public String getName() {
        return "Order";
    }

    @Override
    public String getIdColumn() {
        return "OrderID";
    }

    @Override
    public RowMapper getWrapper() {
        return new OrderWrapper();
    }
}
