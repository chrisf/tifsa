package org.jsack.tifsa.Database.Manufacturer;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by julius on 3/21/2017.
 */
public class ManufacturerWrapper implements org.springframework.jdbc.core.RowMapper<Manufacturer>{
    public Manufacturer mapRow(ResultSet rs, int rowNum) throws SQLException{
        Manufacturer manufacturer = new Manufacturer();

        manufacturer.setManufacturerID(rs.getInt("manufacturerID"));
        manufacturer.setManufacturerName(rs.getString("ManufacturerName"));

        return manufacturer;
    }
}
