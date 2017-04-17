package org.jsack.tifsa.Database.OrderStatus;

import org.jsack.tifsa.Database.Interfaces.ISchema;
import org.springframework.jdbc.core.RowMapper;

/**
 * Created by aaron on 4/17/17.
 */
public class OrderStatusSchema implements ISchema {
    @Override
    public String getName() {
        return "OrderStatus";
    }

    @Override
    public String getIdColumn() {
        return "OrderStatusID";
    }

    @Override
    public RowMapper getWrapper() {
        return new OrderStatusWrapper();
    }
}