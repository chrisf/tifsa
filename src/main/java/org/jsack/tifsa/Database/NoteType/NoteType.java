package org.jsack.tifsa.Database.NoteType;

/**
 * Created by julius on 3/23/2017.
 */

public class NoteType {
    private long noteTypeId;
    private String noteTypeDescription;

    public long getNoteTypeId(){return noteTypeId;}
    public void setNoteTypeId(long noteTypeId){this.noteTypeId = noteTypeId;}

    public String getNoteTypeDescription(){return noteTypeDescription;}
    public void setNoteTypeDescription(String noteTypeDescription){this.noteTypeDescription = noteTypeDescription;}
}
