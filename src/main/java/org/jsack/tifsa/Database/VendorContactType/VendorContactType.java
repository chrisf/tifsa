package org.jsack.tifsa.Database.VendorContactType;

/**
 * Created by chris on 3/20/17.
 */
public class VendorContactType {
    private long vendorContactTypeId;
    private String vendorContactTypeDescription;
    private boolean deleted;

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
    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
