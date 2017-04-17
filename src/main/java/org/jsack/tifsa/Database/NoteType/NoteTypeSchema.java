package org.jsack.tifsa.Database.NoteType;

import org.jsack.tifsa.Database.Interfaces.ISchema;
import org.springframework.jdbc.core.RowMapper;

/**
 * Created by Admin on 4/16/2017.
 */
public class NoteTypeSchema implements ISchema {
    @Override
    public String getName() {
        return "NoteType";
    }

    @Override
    public String getIdColumn() {
        return "NoteTypeID";
    }

    @Override
    public RowMapper getWrapper() {
        return new NoteTypeWrapper();
    }
}
