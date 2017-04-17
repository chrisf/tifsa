package org.jsack.tifsa.Database.VendorContactCategoryMember;

/**
 * Created by chris on 3/20/17.
 */
public class VendorContactCategoryMember {
    private long vendorContactId;
    private long vendorContactCategoryId;
    private boolean deleted;

    public long getVendorContactId() {
        return vendorContactId;
    }

    public void setVendorContactId(long vendorContactId) {
        this.vendorContactId = vendorContactId;
    }

    public long getVendorContactCategoryId() {
        return vendorContactCategoryId;
    }

    public void setVendorContactCategoryId(long vendorContactCategoryId) {
        this.vendorContactCategoryId = vendorContactCategoryId;
    }
    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
