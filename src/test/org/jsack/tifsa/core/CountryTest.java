package org.jsack.tifsa.core;

import org.jsack.tifsa.Database.Country.Country;
import org.jsack.tifsa.Database.Country.CountryDAO;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

/**
 * Created by cfitz on 3/16/17.
 */
public class CountryTest {
    @Test
    public void testSelectAll(){
        CountryDAO countryDAO = new CountryDAO();
        List<Country> countries = countryDAO.selectAll();

        assertNotNull(countries);
        assertFalse(countries.isEmpty());

        countries.forEach(c -> System.out.println(c.toString()));
    }

    @Test
    public void testFindByName() {
        CountryDAO countryDAO = new CountryDAO();
        Country country = countryDAO.selectByName("United States of America");

        assertNotNull(country);

        System.out.println(country.toString());
    }

    @Test
    public void testFindById() {
        CountryDAO countryDAO = new CountryDAO();
        Country country = countryDAO.selectById(1);
        assertNotNull(country);

        System.out.println(country.toString());
    }
}
