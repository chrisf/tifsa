package org.jsack.tifsa.Database.OrderNote;

import org.jsack.tifsa.Database.Interfaces.ISchema;
import org.springframework.jdbc.core.RowMapper;

/**
 * Created by aaron on 4/17/17.
 */
public class OrderNoteSchema implements ISchema {
    @Override
    public String getName() {
        return "OrderNote";
    }

    @Override
    public String getIdColumn() {
        return "OrderNoteID";
    }


    @Override
    public RowMapper getWrapper() {
        return new OrderNoteWrapper();
    }
}
