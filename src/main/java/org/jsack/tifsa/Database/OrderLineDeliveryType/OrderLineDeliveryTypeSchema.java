package org.jsack.tifsa.Database.OrderLineDeliveryType;

import org.jsack.tifsa.Database.Interfaces.ISchema;
import org.springframework.jdbc.core.RowMapper;

/**
 * Created by aaron on 4/17/17.
 */
public class OrderLineDeliveryTypeSchema implements ISchema {
    @Override
    public String getName() {
        return "OrderLineDeliveryType";
    }

    @Override
    public String getIdColumn() {
        return "OrderLineDeliveryTypeID";
    }

    @Override
    public RowMapper getWrapper() {
        return new OrderLineDeliveryTypeWrapper();
    }
}
