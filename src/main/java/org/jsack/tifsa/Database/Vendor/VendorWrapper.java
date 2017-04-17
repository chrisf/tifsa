package org.jsack.tifsa.Database.Vendor;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by aaron on 4/17/17.
 */
public class VendorWrapper implements RowMapper<Vendor> {
    @Override
    public Vendor mapRow(ResultSet rs, int rowNum) throws SQLException {
        Vendor vendor = new Vendor();

        vendor.setVendorId(rs.getLong("VendorID"));
        vendor.setVendorName(rs.getString("VendorName"));
        vendor.setDeleted(rs.getString("Deleted").equalsIgnoreCase("1"));

        return vendor;
    }
}
