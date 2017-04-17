package org.jsack.tifsa.Database.Vendor;

import org.jsack.tifsa.Database.Interfaces.ISchema;
import org.springframework.jdbc.core.RowMapper;

/**
 * Created by aaron on 4/17/17.
 */
public class VendorSchema implements ISchema {
    @Override
    public String getName() {
        return "Vendor";
    }

    @Override
    public String getIdColumn() {
        return "VendorID";
    }

    @Override
    public RowMapper getWrapper() {
        return new VendorWrapper();

    }
}
