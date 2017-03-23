package org.jsack.tifsa.Database.VendorContactType;

/**
 * Created by chris on 3/20/17.
 */
public class VendorContactType {
    private long vendorContactTypeId;
    private String vendorContactTypeDescription;

    public long getVendorContactTypeId() {
        return vendorContactTypeId;
    }

    public void setVendorContactTypeId(long vendorContactTypeId) {
        this.vendorContactTypeId = vendorContactTypeId;
    }

    public String getVendorContactTypeDescription() {
        return vendorContactTypeDescription;
    }

    public void setVendorContactTypeDescription(String vendorContactTypeDescription) {
        this.vendorContactTypeDescription = vendorContactTypeDescription;
    }
}
