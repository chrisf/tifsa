package org.jsack.tifsa.Database.Country;

/**
 * Created by aaron on 3/16/17.
 */
public class Country {
    private long countryId;
    private String countryName;
    private boolean deleted;

    public long getCountryId() {
        return countryId;
    }

    public void setCountryId(long countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String toString() {
        return getCountryId() + " - " + getCountryName();
    }
}