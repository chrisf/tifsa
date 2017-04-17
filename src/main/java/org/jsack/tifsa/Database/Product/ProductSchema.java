package org.jsack.tifsa.Database.Product;

import org.jsack.tifsa.Database.Interfaces.ISchema;
import org.springframework.jdbc.core.RowMapper;

/**
 * Created by aaron on 4/17/17.
 */
public class ProductSchema implements ISchema {
    @Override
    public String getName() {
        return "Product";
    }

    @Override
    public String getIdColumn() {
        return "ProductID";
    }

    @Override
    public RowMapper getWrapper() {
        return new ProductWrapper();
    }
}
