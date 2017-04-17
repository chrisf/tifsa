package org.jsack.tifsa.Database.NoteType;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Admin on 4/16/2017.
 */
public class NoteTypeWrapper implements RowMapper<NoteType> {
    @Override
    public NoteType mapRow(ResultSet rs, int rowNum) throws SQLException {
        NoteType noteType = new NoteType();

        noteType.setNoteTypeId(rs.getLong("NoteTypeID"));
        noteType.setNoteTypeDescription(rs.getString("NoteTypeDescription"));
        noteType.setDeleted(rs.getString("Deleted").equalsIgnoreCase("1"));

        return noteType;
    }
}
