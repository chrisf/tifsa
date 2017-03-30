package org.jsack.tifsa.Database.Manufacturer;

import org.jsack.tifsa.Database.ModelBase;

import java.util.List;

/**
 * Created by jayjay on 3/21/2017.
 */
public abstract class ManufacturerBase extends ModelBase{
    public abstract List<Manufacturer> selectAll();
    public abstract Manufacturer selectById(long id);
    public abstract Manufacturer selectByName(String manufacturerName);

    public abstract long create (Manufacturer m);
    public abstract int delete(long id);
    public abstract int update(Manufacturer m);
}
