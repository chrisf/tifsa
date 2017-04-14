package org.jsack.tifsa.Database.Brand;

import org.jsack.tifsa.Database.Interfaces.ISchema;
import org.springframework.jdbc.core.RowMapper;

/**
 * Created by Admin on 4/12/2017.
 */
public class BrandSchema implements ISchema {
    @Override
    public String getIdColumn() {
        return "BrandID";
    }
    @Override
    public String getName() {
        return "Brand";
    }

    @Override
    public RowMapper getWrapper() {
        return new BrandWrapper();
    }
}
