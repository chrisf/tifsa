package org.jsack.tifsa.Database.OrderNote;

import java.sql.Date;
import java.time.LocalDateTime;

/**
 * Created by chris on 3/20/17.
 */
public class OrderNote {
    private int orderNoteId;
    private int noteTypeId;
    private int orderId;
    private String orderNoteDescription;
    private Date orderNoteDate;

    public int getOrderNoteId() {
        return orderNoteId;
    }

    public void setOrderNoteId(int orderNoteId) {
        this.orderNoteId = orderNoteId;
    }

    public int getNoteTypeId() {
        return noteTypeId;
    }

    public void setNoteTypeId(int noteTypeId) {
        this.noteTypeId = noteTypeId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderNoteDescription() {
        return orderNoteDescription;
    }

    public void setOrderNoteDescription(String orderNoteDescription) {
        this.orderNoteDescription = orderNoteDescription;
    }

    public Date getOrderNoteDate() {
        return orderNoteDate;
    }

    public void setOrderNoteDate(Date orderNoteDate) {
        this.orderNoteDate = orderNoteDate;
    }
}
