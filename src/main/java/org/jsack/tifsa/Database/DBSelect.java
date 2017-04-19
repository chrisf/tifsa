package org.jsack.tifsa.Database;

import org.jsack.tifsa.Database.Interfaces.ISchema;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

/**
 * Created by Admin on 4/12/2017.
 */
public class DBSelect {
    private JdbcTemplate template;
    private NamedParameterJdbcTemplate namedTemplate;

    public DBSelect () {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        template = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
        namedTemplate = (NamedParameterJdbcTemplate) applicationContext.getBean("jdbcNamedTemplate");
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
