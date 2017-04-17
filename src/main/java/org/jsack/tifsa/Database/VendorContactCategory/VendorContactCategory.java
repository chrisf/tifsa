package org.jsack.tifsa.Database.VendorContactCategory;

/**
 * Created by chris on 3/20/17.
 */
public class VendorContactCategory {
    private long vendorContactCategoryId;
    private String vendorContactCategoryDescription;
    private boolean deleted;

    public long getVendorContactCategoryId() {
        return vendorContactCategoryId;
    }

    public void setVendorContactCategoryId(long vendorContactCategoryId) {
        this.vendorContactCategoryId = vendorContactCategoryId;
    }

    public String getVendorContactCategoryDescription() {
        return vendorContactCategoryDescription;
    }

    public void setVendorContactCategoryDescription(String vendorContactCategoryDescription) {
        this.vendorContactCategoryDescription = vendorContactCategoryDescription;
    }
    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
