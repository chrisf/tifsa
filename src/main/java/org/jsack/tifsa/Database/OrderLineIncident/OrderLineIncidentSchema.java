package org.jsack.tifsa.Database.OrderLineIncident;

import org.jsack.tifsa.Database.Interfaces.ISchema;
import org.springframework.jdbc.core.RowMapper;

/**
 * Created by aaron on 4/17/17.
 */
public class OrderLineIncidentSchema implements ISchema {
    @Override
    public String getName() {
        return "OrderLineIncident";
    }

    @Override
    public String getIdColumn() {
        return "OrderLineIncidentID";
    }

    @Override
    public RowMapper getWrapper() {
        return new OrderLineIncidentWrapper();
    }
}
