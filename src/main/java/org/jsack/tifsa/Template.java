package org.jsack.tifsa;

import org.jsack.tifsa.Database.ModelBase;

import java.util.List;

/**
 * Created by Admin on 4/12/2017.
 */
public class Template extends ModelBase {
    public Template() {
        this.setSimpleInsert("", "");
    }
    public List<Template> selectAll() { return null; }
    public Template select() { return null; }
    public int update() { return 0; }
    public int delete() { return 0; }
}
