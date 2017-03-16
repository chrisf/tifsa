package org.jsack.tifsa.core;

import org.jsack.tifsa.DBModelWrappers.CountryWrapper;
import org.jsack.tifsa.DBModels.Country;
import org.jsack.tifsa.ModelDAOs.CountryDAO;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Created by cfitz on 3/16/17.
 */
public class CountryTest {
    @Test
    @Ignore
    public void testSelectAll(){
        CountryDAO countryDAO = new CountryDAO();
        List<Country> countries = countryDAO.selectAll();
        countries.forEach(c -> System.out.println(c.getCountryName()));
        assert(!countries.isEmpty());
    }

    @Test
    @Ignore
    public void testFindByName() {
        CountryDAO countryDAO = new CountryDAO();
        List<Country> countries = countryDAO.findByName("United States");
        countries.forEach( c -> System.out.println(c.getCountryName()));
        assert(!countries.isEmpty());
    }

    @Test
    @Ignore
    public void testFindById() {
        CountryDAO countryDAO = new CountryDAO();
        Country country = countryDAO.findById(1);
        System.out.println(country.toString());
        assert(country != null);
    }
}
