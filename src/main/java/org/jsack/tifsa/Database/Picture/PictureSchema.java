package org.jsack.tifsa.Database.Picture;

import org.jsack.tifsa.Database.Interfaces.ISchema;
import org.springframework.jdbc.core.RowMapper;

/**
 * Created by aaron on 4/17/17.
 */
public class PictureSchema implements ISchema {
    @Override
    public String getName() {
        return "Picture";
    }

    @Override
    public String getIdColumn() {
        return "PictureID";
    }

    @Override
    public RowMapper getWrapper() {
        return new PictureWrapper();
    }
}
