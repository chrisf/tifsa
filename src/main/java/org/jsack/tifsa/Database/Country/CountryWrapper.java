package org.jsack.tifsa.Database.Country;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by cfitz on 3/16/17.
 */
public class CountryWrapper implements org.springframework.jdbc.core.RowMapper<Country> {
    public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
        Country country = new Country();

        country.setCountryID(rs.getInt("CountryID"));
        country.setCountryName(rs.getString("CustomerName"));

        return country;
    }
}
