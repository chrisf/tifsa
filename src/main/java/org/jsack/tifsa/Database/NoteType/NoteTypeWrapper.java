package org.jsack.tifsa.Database.NoteType;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by julius on 3/23/2017.
 */
public class NoteTypeWrapper implements org.springframework.jdbc.core.RowMapper<NoteType>{
    public NoteType mapRow(ResultSet rs, int rowNum) throws SQLException {
        NoteType noteType = new NoteType();

        noteType.setNoteTypeId(rs.getInt("NoteTypeID"));
        noteType.setNoteTypeDescription(rs.getString("NoteTypeDescription"));

        return noteType;
    }
}