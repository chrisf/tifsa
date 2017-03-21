package org.jsack.tifsa.Database.VendorContact;

/**
 * Created by chris on 3/20/17.
 */
public class VendorContact {
    private int vendorContactId;
    private int vendorContactTypeId;
    private int vendorContactInfo;
    private boolean vendorContact;
    private int vendorId;

    public int getVendorContactId() {
        return vendorContactId;
    }

    public void setVendorContactId(int vendorContactId) {
        this.vendorContactId = vendorContactId;
    }

    public int getVendorContactTypeId() {
        return vendorContactTypeId;
    }

    public void setVendorContactTypeId(int vendorContactTypeId) {
        this.vendorContactTypeId = vendorContactTypeId;
    }

    public int getVendorContactInfo() {
        return vendorContactInfo;
    }

    public void setVendorContactInfo(int vendorContactInfo) {
        this.vendorContactInfo = vendorContactInfo;
    }

    public boolean isVendorContact() {
        return vendorContact;
    }

    public void setVendorContact(boolean vendorContact) {
        this.vendorContact = vendorContact;
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }
}
