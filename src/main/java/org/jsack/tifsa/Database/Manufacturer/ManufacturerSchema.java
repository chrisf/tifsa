package org.jsack.tifsa.Database.Manufacturer;

import org.jsack.tifsa.Database.Interfaces.ISchema;
import org.springframework.jdbc.core.RowMapper;

/**
 * Created by Admin on 4/16/2017.
 */
public class ManufacturerSchema implements ISchema {
    @Override
    public String getName() {
        return "Manufacturer";
    }

    @Override
    public String getIdColumn() {
        return "ManufacturerID";
    }

    @Override
    public RowMapper getWrapper() {
        return new ManufacturerWrapper();
    }
}
