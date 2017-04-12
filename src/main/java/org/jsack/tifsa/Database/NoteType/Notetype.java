package org.jsack.tifsa.Database.NoteType;
/**
 * Created by steven on 4/11/17.
 */

public class Notetype {
  private Long notetypeid;
  private String notetypedescription;

  public Long getNotetypeid() {
    return notetypeid;
  }

  public void setNotetypeid(Long notetypeid) {
    this.notetypeid = notetypeid;
  }

  public String getNotetypedescription() {
    return notetypedescription;
  }

  public void setNotetypedescription(String notetypedescription) {
    this.notetypedescription = notetypedescription;
  }
}
