package org.jsack.tifsa.Database.IncidentType;

import org.jsack.tifsa.Database.Interfaces.ISchema;
import org.springframework.jdbc.core.RowMapper;

/**
 * Created by Admin on 4/16/2017.
 */
public class IncidentTypeSchema implements ISchema {
    @Override
    public String getName() {
        return "IncidentType";
    }

    @Override
    public String getIdColumn() {
        return "IncidentTypeID";
    }

    @Override
    public RowMapper getWrapper() {
        return new IncidentTypeWrapper();
    }
}
