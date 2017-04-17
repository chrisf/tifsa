package org.jsack.tifsa.Database.Manufacturer;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Admin on 4/16/2017.
 */
public class ManufacturerWrapper implements RowMapper<Manufacturer> {

    @Override
    public Manufacturer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Manufacturer manufacturer = new Manufacturer();

        manufacturer.setManufacturerId(rs.getLong("ManufacturerID"));
        manufacturer.setManufacturerName(rs.getString("ManufacturerName"));
        manufacturer.setDeleted(rs.getString("Deleted").equalsIgnoreCase("1"));

        return manufacturer;
    }
}
