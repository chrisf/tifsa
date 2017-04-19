package org.jsack.tifsa.Database;

import org.jsack.tifsa.Database.Interfaces.ISchema;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Admin on 4/12/2017.
 */
public class DBSelect {
    private JdbcTemplate template;
    private NamedParameterJdbcTemplate namedTemplate;
    private DataSource dataSource;

    public DBSelect () {

    }
    public JdbcTemplate getTemplate() {
        return template;
    }
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        template = new JdbcTemplate(dataSource);
        namedTemplate = new NamedParameterJdbcTemplate(template);
    }
    public List selectAll(ISchema schema) {
        String sql = String.format("SELECT * FROM %s", schema.getName());
        if(template != null ) {
            return template.query(sql, schema.getWrapper());
        }
        return null;
    }
    public Object select(ISchema schema, Long id) {
        String sql = String.format("SELECT * FROM %s WHERE %s = ?", schema.getName(), schema.getIdColumn());
        if(template != null) {
            return template.queryForObject(sql, new Object[] { id }, schema.getWrapper());
        }
        return null;
    }

}
