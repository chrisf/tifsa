package org.jsack.tifsa.Database.VendorContact;

/**
 * Created by chris on 3/20/17.
 */
public class VendorContact {
    private long vendorContactId;
    private long vendorContactTypeId;
    private String vendorContactInfo;
    private boolean vendorContactPrimary;
    private long vendorId;
    private boolean deleted;

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

    public String getVendorContactInfo() {
        return vendorContactInfo;
    }

    public void setVendorContactInfo(String vendorContactInfo) {
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
    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
