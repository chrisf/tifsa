package org.jsack.tifsa.Database.VendorContactCategoryMember;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by aaron on 4/17/17.
 */
public class VendorContactCategoryMemberWrapper implements RowMapper<VendorContactCategoryMember> {
    @Override
    public VendorContactCategoryMember mapRow(ResultSet rs, int rowNum) throws SQLException {
        VendorContactCategoryMember vendorContactCategoryMember = new VendorContactCategoryMember();

        vendorContactCategoryMember.setVendorContactId(rs.getLong("VendorContactID"));
        vendorContactCategoryMember.setVendorContactCategoryId(rs.getLong("VendorContactCategoryID"));
        vendorContactCategoryMember.setDeleted(rs.getString("Deleted").equalsIgnoreCase("1"));

        return vendorContactCategoryMember;
    }
}
