package org.jsack.tifsa.Database.NoteType;

public class NoteType {
  private Long noteTypeId;
  private String noteTypeDescription;
  private boolean deleted;

  public Long getNoteTypeId() {
    return noteTypeId;
  }

  public void setNoteTypeId(Long noteTypeId) {
    this.noteTypeId = noteTypeId;
  }

  public String getNoteTypeDescription() {
    return noteTypeDescription;
  }

  public void setNoteTypeDescription(String noteTypeDescription) {
    this.noteTypeDescription = noteTypeDescription;
  }
public boolean isDeleted() {
    return deleted;
  }

  public void setDeleted(boolean deleted) {
    this.deleted = deleted;
  }
}
