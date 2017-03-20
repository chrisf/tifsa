package org.jsack.tifsa.Database.Picture;

/**
 * Created by chris on 3/20/17.
 */
public class Picture {
    private int productId;
    private int pictureId;
    private byte[] pictureData;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }

    public byte[] getPictureData() {
        return pictureData;
    }

    public void setPictureData(byte[] pictureData) {
        this.pictureData = pictureData;
    }
}
