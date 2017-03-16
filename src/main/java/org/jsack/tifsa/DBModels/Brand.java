package org.jsack.tifsa.DBModels;

/**
 * Created by aaron on 3/16/17.
 */
public class Brand {
    private int brandId;
    private int manufacturerId;
    private String brandName;

    public int getBrandID() {
        return brandId;
    }

    public void setBrandID(int brandId) {
        brandId = brandId;
    }

    public int getManufacturerID() {
        return manufacturerId;
    }

    public void setManufacturerID(int manufacturerId) {
        manufacturerId = manufacturerId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        brandName = brandName;
    }

}
