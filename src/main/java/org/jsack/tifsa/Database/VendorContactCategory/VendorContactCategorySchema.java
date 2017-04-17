package org.jsack.tifsa.Database.VendorContactCategory;

import org.jsack.tifsa.Database.Interfaces.ISchema;
import org.springframework.jdbc.core.RowMapper;

/**
 * Created by aaron on 4/17/17.
 */
public class VendorContactCategorySchema implements ISchema {
    @Override
    public String getName() {
        return "VendorContactCategory";
    }

    @Override
    public String getIdColumn() {
        return "VendorContactCategoryID";
    }

    @Override
    public RowMapper getWrapper() {
        return new VendorContactCategoryWrapper();
    }
}
