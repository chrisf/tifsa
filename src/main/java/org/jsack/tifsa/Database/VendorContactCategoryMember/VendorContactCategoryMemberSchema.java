package org.jsack.tifsa.Database.VendorContactCategoryMember;

import org.jsack.tifsa.Database.Interfaces.ISchema;
import org.springframework.jdbc.core.RowMapper;

/**
 * Created by aaron on 4/17/17.
 */
public class VendorContactCategoryMemberSchema implements ISchema {
    @Override
    public String getName() {
        return "VendorContactCategoryMember";
    }

    @Override
    public String getIdColumn() {
        return "VendorContactCategoryMemberID";
    }

    @Override
    public RowMapper getWrapper() {
        return new VendorContactCategoryMemberWrapper();
    }
}
