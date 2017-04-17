package org.jsack.tifsa.Database.OrderNote;

import java.sql.Timestamp;

/**
 * Created by chris on 3/20/17.
 */
public class OrderNote {
    private long orderNoteId;
    private long noteTypeId;
    private long orderId;
    private String orderNoteDescription;
    private Timestamp orderNoteDate;
    private boolean deleted;

    public long getOrderNoteId() {
        return orderNoteId;
    }

    public void setOrderNoteId(long orderNoteId) {
        this.orderNoteId = orderNoteId;
    }

    public long getNoteTypeId() {
        return noteTypeId;
    }

    public void setNoteTypeId(long noteTypeId) {
        this.noteTypeId = noteTypeId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getOrderNoteDescription() {
        return orderNoteDescription;
    }

    public void setOrderNoteDescription(String orderNoteDescription) {
        this.orderNoteDescription = orderNoteDescription;
    }

    public Timestamp getOrderNoteDate() {
        return orderNoteDate;
    }

    public void setOrderNoteDate(Timestamp orderNoteDate) {
        this.orderNoteDate = orderNoteDate;
    }
    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
