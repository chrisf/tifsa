package org.jsack.tifsa.Database.Vendor;

/**
 * Created by chris on 3/20/17.
 */
public class Vendor {
    private long vendorId;
    private String vendorName;

    public long getVendorId() {
        return vendorId;
    }

    public void setVendorId(long vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }
}
