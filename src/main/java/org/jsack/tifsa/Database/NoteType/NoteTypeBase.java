package org.jsack.tifsa.Database.NoteType;

import org.jsack.tifsa.Database.ModelBase;

import java.util.List;

/**
 * Created by julius on 3/23/2017.
 */
public abstract class NoteTypeBase extends ModelBase {
    public abstract List<NoteType> selectAll();
    public abstract NoteType selectById(long id);
    public abstract NoteType selectByDescription(String noteTypeDescription);

    public abstract long create (NoteType noteType);
    public abstract int delete (long id);
    public abstract int update (NoteType noteType);
}
