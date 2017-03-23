package org.jsack.tifsa.Database.NoteType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by julius on 3/23/2017.
 */
public class NoteTypeDAO extends NoteTypeBase{
    @Override
    public List<NoteType> selectAll(){
        String sql = "SELECT * FROM NoteType";
        List<NoteType> noteTypes = getTemplate().query(sql, new NoteTypeWrapper());
        return noteTypes;
    }

    @Override
    public NoteType selectById(long id) {
        String sql = "SELECT * FROM NoteType WHERE NoteTypeID = ?";
        return getTemplate().queryForObject(sql, new Object[] { id }, new NoteTypeWrapper());
    }

    @Override
    public NoteType selectByDescription(String noteTypeDescription) {
        String sql = "SELECT * FROM NoteType WHERE NoteTypeDescription = ?";
        return getTemplate().queryForObject(sql, new Object[] { noteTypeDescription }, new NoteTypeWrapper());
    }

    @Override
    public long create(NoteType noteType) {
        Map<String, Object> attributes = new HashMap();
        attributes.put("NoteTypeDescription", noteType.getNoteTypeDescription());
        return this.getSimpleInsert().executeAndReturnKey(attributes).longValue();
    }

    @Override
    public int delete(long id) {
        return this.delete("NoteType", "NoteTypeID", id);
    }

    @Override
    public int update(NoteType noteType) {
        String sql = "UPDATE NoteType"+
                    "SET NoteTypeDescription = :noteTypeDescription"+
                    "WHERE NoteTypeID = :noteTypeID";

        Map<String, Object> attributes = new HashMap();

        attributes.put("noteTypeDescription", noteType.getNoteTypeDescription());
        attributes.put("noteTypeId", noteType.getNoteTypeId());

        return this.getNamedTemplate().update(sql, attributes);

    }
}
