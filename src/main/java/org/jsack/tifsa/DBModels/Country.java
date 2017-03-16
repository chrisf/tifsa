package org.jsack.tifsa.DBModels;

/**
 * Created by aaron on 3/16/17.
 */
public class Country {
    private int CountryID;
    private String CountryName;

    public int getCountryID() {
        return CountryID;
    }

    public void setCountryID(int countryID) {
        CountryID = countryID;
    }

    public String getCountryName() {
        return CountryName;
    }

    public void setCountryName(String countryName) {
        CountryName = countryName;
    }
}