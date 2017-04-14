package org.jsack.tifsa.Database.Country;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cfitz on 3/16/17.
 */
public class CountryDAO extends CountryBase
{
    @Override
    public List<Country> selectAll() {
        String sql = "SELECT * FROM Country";
        List<Country> countries = getTemplate().query(sql, new CountryWrapper());
        return countries;
    }

    @Override
    public Country selectById(long id) {
        String sql = "SELECT * FROM Country WHERE CountryID = ?";
        return getTemplate().queryForObject(sql, new Object[] { id }, new CountryWrapper());
    }

    @Override
    public Country selectByName(String countryName) {
        String sql = "SELECT * FROM Country WHERE CountryName = ?";
        return getTemplate().queryForObject(sql, new Object[] { countryName }, new CountryWrapper());
    }

    @Override
    public long create(Country c) {
        // holds row attributes
        Map<String, Object> attributes = new HashMap();

        // set the attributes
        attributes.put("CountryName", c.getCountryName());

        // insert and return new primary key
        return this.getSimpleInsert().executeAndReturnKey(attributes).longValue();
    }

    @Override
    public int delete(long id) {
        return this.delete("Country", "CountryID", id);
    }

    @Override
    public int update(Country c) {
        String sql = "UPDATE Country" +
                     " SET CountryName = :countryName" +
                     " WHERE CountryID = :id";

        Map<String, Object> attributes = new HashMap();

        attributes.put("countryName", c.getCountryName());
        attributes.put("countryId", c.getCountryId());

        return this.getNamedTemplate().update(sql, attributes);
    }
}
