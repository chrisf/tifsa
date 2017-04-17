package org.jsack.tifsa.Database.OrderStatusHistory;

import org.jsack.tifsa.Database.Interfaces.ISchema;
import org.springframework.jdbc.core.RowMapper;

/**
 * Created by aaron on 4/17/17.
 */
public class OrderStatusHistorySchema implements ISchema {
    @Override
    public String getName() {
        return "OrderStatusHistory";
    }

    @Override
    public String getIdColumn() {
        return "OrderStatusHistoryID";
    }

    @Override
    public RowMapper getWrapper() {
        return new OrderStatusHistoryWrapper();
    }
}
