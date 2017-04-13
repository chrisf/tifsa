package org.jsack.tifsa.Database.Country;

import org.jsack.tifsa.Database.Interfaces.ISchema;
import org.springframework.jdbc.core.RowMapper;

/**
 * Created by aaron on 4/13/17.
 */
public class CountrySchema implements ISchema {
    @Override
    public String getName() {
        return "Country";
    }

    @Override
    public String getIdColumn() {
        return "CountryID";
    }

    @Override
    public RowMapper getWrapper() {
        return new CountryWrapper();
    }

}
