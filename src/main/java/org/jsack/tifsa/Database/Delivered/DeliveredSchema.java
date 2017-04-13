package org.jsack.tifsa.Database.Delivered;

import org.jsack.tifsa.Database.Interfaces.ISchema;
import org.springframework.jdbc.core.RowMapper;

/**
 * Created by aaron on 4/13/17.
 */
public class DeliveredSchema implements ISchema {
    @Override
    public String getName() {
        return "Delivered";
    }

    @Override
    public String getIdColumn() {
        return "DeliveredID";
    }

    @Override
    public RowMapper getWrapper() {
        return new DeliveredWrapper();
    }
}
