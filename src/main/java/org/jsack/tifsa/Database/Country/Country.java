package org.jsack.tifsa.Database.Country;

/**
 * Created by aaron on 3/16/17.
 */
public class Country {
    private long CountryID;
    private String CountryName;

    public long getCountryID() {
        return CountryID;
    }

    public void setCountryID(long countryID) {
        CountryID = countryID;
    }

    public String getCountryName() {
        return CountryName;
    }

    public void setCountryName(String countryName) {
        CountryName = countryName;
    }

    public String toString() {
        return getCountryID() + " - " + getCountryName();
    }
}