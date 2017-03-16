package org.jsack.tifsa.Database.Country;

import org.jsack.tifsa.Database.ModelBase;

import java.util.List;

/**
 * Created by cfitz on 3/16/17.
 */
public abstract class CountryBase extends ModelBase {

    public abstract List<Country> selectAll();

    public abstract Country findById(int id);

    public abstract List<Country> findByName(String countryName);

    public abstract void addNew(String countryName);

    public abstract void delete(int id);

    public abstract void update(int id, Country c);
}