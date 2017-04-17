package org.jsack.tifsa.Database.VendorContactType;

import org.jsack.tifsa.Database.Interfaces.ISchema;
import org.springframework.jdbc.core.RowMapper;

/**
 * Created by aaron on 4/17/17.
 */
public class VendorContactTypeSchema implements ISchema {
    @Override
    public String getName() {
        return "VendorContactType";
    }

    @Override
    public String getIdColumn() {
        return "VendorContactTypeID";
    }

    @Override
    public RowMapper getWrapper() {
        return new VendorContactTypeWrapper();
    }
}
