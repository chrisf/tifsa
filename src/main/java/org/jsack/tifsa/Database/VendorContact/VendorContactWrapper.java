package org.jsack.tifsa.Database.VendorContact;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by aaron on 4/17/17.
 */
public class VendorContactWrapper implements RowMapper<VendorContact> {
    @Override
    public VendorContact mapRow(ResultSet rs, int rowNum) throws SQLException {
        VendorContact vendorContact = new VendorContact();

        vendorContact.setVendorContactId(rs.getLong("VendorContactID"));
        vendorContact.setVendorContactTypeId(rs.getLong("VendorContactTypeID"));
        vendorContact.setVendorContactInfo(rs.getString("VendorContactInfo"));
        vendorContact.setVendorContactPrimary(rs.getBoolean("VendorContactPrimary"));
        vendorContact.setVendorId(rs.getLong("VendorID"));
        vendorContact.setDeleted(rs.getString("Deleted").equalsIgnoreCase("1"));

        return vendorContact;
    }
}
