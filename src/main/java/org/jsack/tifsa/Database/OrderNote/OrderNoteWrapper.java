package org.jsack.tifsa.Database.OrderNote;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by aaron on 4/17/17.
 */
public class OrderNoteWrapper implements RowMapper<OrderNote> {
    @Override
    public OrderNote mapRow(ResultSet rs, int rowNum) throws SQLException {
        OrderNote orderNote = new OrderNote();

        orderNote.setOrderNoteId(rs.getLong("OrderNoteID"));
        orderNote.setNoteTypeId(rs.getLong("NoteTypeID"));
        orderNote.setOrderId(rs.getLong("OrderID"));
        orderNote.setOrderNoteDescription(rs.getString("OrderNoteDescription"));
        orderNote.setOrderNoteDate(rs.getTimestamp("OrderNoteDate"));

        return orderNote;
    }
}
