package org.jsack.tifsa.Database;

import org.jsack.tifsa.Database.Interfaces.ISchema;
import org.jsack.tifsa.Utility;

import java.util.List;

/**
 * Created by Admin on 4/12/2017.
 */
public class DBSelect {
    public List selectAll(ISchema schema) {
        String sql = String.format("SELECT * FROM %s", schema.getName());
        return Utility.getJdbcTemplate().query(sql, schema.getWrapper());
    }

    public Object select(ISchema schema, Long id) {
        String sql = String.format("SELECT * FROM %s WHERE %s = ?", schema.getName(), schema.getIdColumn());
        return Utility.getJdbcTemplate().queryForObject(sql, new Object[]{id}, schema.getWrapper());
    }

}
