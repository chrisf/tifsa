package org.jsack.tifsa.Database.VendorContactCategory;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by aaron on 4/17/17.
 */
public class VendorContactCategoryWrapper implements RowMapper<VendorContactCategory> {
    @Override
    public VendorContactCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
        VendorContactCategory vendorContactCategory = new VendorContactCategory();

        vendorContactCategory.setVendorContactCategoryId(rs.getLong("VendorContactCategoryID"));
        vendorContactCategory.setVendorContactCategoryDescription(rs.getString("VendorContactCategoryDescription"));
        vendorContactCategory.setDeleted(rs.getString("Deleted").equalsIgnoreCase("1"));

        return vendorContactCategory;
    }
}
