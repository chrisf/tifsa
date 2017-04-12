package org.jsack.tifsa.Database.Manufacturer;

import org.jsack.tifsa.Database.ModelBase;

import java.util.List;

/**
 * Created by jayjay on 3/21/2017.
 */
public abstract class ManufacturerBase extends ModelBase{
    public abstract List<Manufacturer> selectAll();
    public abstract Manufacturer selectById(int id);
    public abstract Manufacturer selectByName(String manufacturerName);

    public abstract int create (Manufacturer m);
    public abstract int delete(int id);
    public abstract int update(Manufacturer m);
}
