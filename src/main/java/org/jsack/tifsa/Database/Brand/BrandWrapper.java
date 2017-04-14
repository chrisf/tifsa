package org.jsack.tifsa.Database.Brand;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by aaron on 3/21/17.
 */
public class BrandWrapper implements RowMapper<Brand> {

    @Override
    public Brand mapRow(ResultSet resultSet, int i) throws SQLException {
        Brand brand = new Brand();

        brand.setBrandID(resultSet.getLong("BrandID"));
        brand.setManufacturerID(resultSet.getLong("ManufacturerID"));
        brand.setBrandName(resultSet.getString("BrandName"));
        brand.setDeleted(Boolean.valueOf(resultSet.getString("Deleted")));

        return brand;
    }
}
