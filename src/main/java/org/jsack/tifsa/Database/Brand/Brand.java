package org.jsack.tifsa.Database.Brand;

/**
 * Created by aaron on 3/16/17.
 */
public class Brand {
    private long brandId;
    private long manufacturerId;
    private String brandName;

    public long getBrandID() {
        return brandId;
    }

    public void setBrandID(long brandId) {
        this.brandId = brandId;
    }

    public long getManufacturerID() {
        return manufacturerId;
    }

    public void setManufacturerID(long manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

}
