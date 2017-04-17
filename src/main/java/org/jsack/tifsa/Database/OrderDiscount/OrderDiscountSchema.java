package org.jsack.tifsa.Database.OrderDiscount;

import org.jsack.tifsa.Database.Interfaces.ISchema;
import org.springframework.jdbc.core.RowMapper;

/**
 * Created by Admin on 4/16/2017.
 */
public class OrderDiscountSchema implements ISchema {
    @Override
    public String getName() {
        return "OrderDiscount";
    }

    @Override
    public String getIdColumn() {
        return "OrderDiscountID";
    }

    @Override
    public RowMapper getWrapper() {
        return new OrderDiscountWrapper();
    }
}
