package org.jsack.tifsa.Database.Brand;

import org.jsack.tifsa.Database.ModelBase;

import java.util.List;

/**
 * Created by aaron on 3/21/17.
 */
public abstract class BrandModel extends ModelBase {
    public abstract long create(long manufacturerId, String brandName);
    public abstract int update(long id, long manufacturerId, String brandName);
    public abstract int delete(long id);
    public abstract List<Brand> selectAll();
    public abstract Brand select(long id);
}
