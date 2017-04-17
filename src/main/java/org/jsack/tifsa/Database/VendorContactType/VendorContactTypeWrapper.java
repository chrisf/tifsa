package org.jsack.tifsa.Database.VendorContactType;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by aaron on 4/17/17.
 */
public class VendorContactTypeWrapper implements RowMapper<VendorContactType> {
    @Override
    public VendorContactType mapRow(ResultSet rs, int rowNum) throws SQLException {
        VendorContactType vendorContactType = new VendorContactType();

        vendorContactType.setVendorContactTypeId(rs.getLong("VendorContactTypeID"));
        vendorContactType.setVendorContactTypeDescription(rs.getString("VendorContactTypeDescription"));
        vendorContactType.setDeleted(rs.getString("Deleted").equalsIgnoreCase("1"));

        return vendorContactType;
    }
}
