package org.jsack.tifsa.Database.Country;

import org.jsack.tifsa.Database.ModelBase;

import java.util.List;

/**
 * Created by cfitz on 3/16/17.
 */
public abstract class CountryBase extends ModelBase {

    public abstract List<Country> selectAll();

    public abstract Country selectById(long id);

    public abstract Country selectByName(String countryName);

    public abstract long create(Country c);

    public abstract int delete(long id);

    public abstract int update(Country c);
}