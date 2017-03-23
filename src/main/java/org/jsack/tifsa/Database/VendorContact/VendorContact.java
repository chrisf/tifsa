package org.jsack.tifsa.Database.VendorContact;

/**
 * Created by chris on 3/20/17.
 */
public class VendorContact {
    private long vendorContactId;
    private long vendorContactTypeId;
    private long vendorContactInfo;
    private boolean vendorContactPrimary;
    private long vendorId;

    public long getVendorContactId() {
        return vendorContactId;
    }

    public void setVendorContactId(long vendorContactId) {
        this.vendorContactId = vendorContactId;
    }

    public long getVendorContactTypeId() {
        return vendorContactTypeId;
    }

    public void setVendorContactTypeId(long vendorContactTypeId) {
        this.vendorContactTypeId = vendorContactTypeId;
    }

    public long getVendorContactInfo() {
        return vendorContactInfo;
    }

    public void setVendorContactInfo(long vendorContactInfo) {
        this.vendorContactInfo = vendorContactInfo;
    }

    public boolean isVendorContactPrimary() {
        return vendorContactPrimary;
    }

    public void setVendorContactPrimary(boolean vendorContactPrimary) {
        this.vendorContactPrimary = vendorContactPrimary;
    }

    public long getVendorId() {
        return vendorId;
    }

    public void setVendorId(long vendorId) {
        this.vendorId = vendorId;
    }
}
