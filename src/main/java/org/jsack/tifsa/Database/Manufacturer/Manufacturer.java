package org.jsack.tifsa.Database.Manufacturer;

/**
 * Created by julius on 3/21/2017.
 */
public class Manufacturer {
    private long manufacturerId;
    private String manufacturerName;

    public long getManufacturerId(){return manufacturerId;}
    public void setManufacturerId(long manufacturerId){this.manufacturerId = manufacturerId;}

    public String getManufacturerName(){return manufacturerName;}
    public void setManufacturerName(String manufacturerName){this.manufacturerName = manufacturerName;}

}
