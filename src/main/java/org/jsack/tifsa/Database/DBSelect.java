package org.jsack.tifsa.Database;

import org.jsack.tifsa.Database.Interfaces.ISchema;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * Created by Admin on 4/12/2017.
 */
public class DBSelect<T> {
    private JdbcTemplate template;
    private NamedParameterJdbcTemplate namedTemplate;

    public DBSelect (JdbcTemplate template) {
        this.template = template;
        this.namedTemplate = new NamedParameterJdbcTemplate(template);
    }
    public List<T> selectAll(ISchema schema) {
        String sql = String.format("SELECT * FROM %s", schema.getName());
        if(template != null ) {
            return template.query(sql, schema.getWrapper());
        }
        return null;
    }
    public T select(ISchema schema, Long id) {
        String sql = String.format("SELECT * FROM %s WHERE %s = ?", schema.getName(), schema.getIdColumn());
        if(template != null) {
            return (T)template.queryForObject(sql, new Object[] { id }, schema.getWrapper());
        }
        return null;
    }

}
