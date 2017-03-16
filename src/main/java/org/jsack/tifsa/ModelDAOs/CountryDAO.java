package org.jsack.tifsa.ModelDAOs;

import org.jsack.tifsa.DBModelWrappers.CountryWrapper;
import org.jsack.tifsa.DBModels.Country;
import org.jsack.tifsa.ModelBase.CountryBase;

import java.util.List;

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
    public Country findById(int id) {
        return null;
    }

    @Override
    public List<Country> findByName(String countryName) {
        return null;
    }

    @Override
    public void addNew(String countryName) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(int id, Country c) {

    }
}
