package org.jsack.tifsa.Database;

import org.jsack.tifsa.Database.Interfaces.ISchema;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.Map;

/**
 * Created by Admin on 4/13/2017.
 */
public class DBUpdate {
    private JdbcTemplate template;
    private NamedParameterJdbcTemplate namedTemplate;

    public DBUpdate(JdbcTemplate template) {
        this.template = template;
        this.namedTemplate = new NamedParameterJdbcTemplate(template);
    }
        public int update(ISchema schema, Long id, Map<String,Object> attributes) {
          //creates our initial sql statement
        StringBuilder sql = new StringBuilder(String.format("UPDATE %s SET ", schema.getName()));

        //loops over our attributes, since we have named templates available, we can build a statement using the column
        //as the named variable

        //creates an index, so we know when to stop adding commas
        int i = 0;
        for(Map.Entry<String, Object> entry : attributes.entrySet()) {

            //this will add something like CustomerFirst = :CustomerFirst
            sql.append(String.format("%s = :%s",
                    entry.getKey(), entry.getKey()));

            //If there are more than one attribute, add a comma
            if(i != attributes.size() - 1) {
                sql.append(", ");
            }
            i++;
        }

        //add the WHERE part of the statement
        sql.append(String.format(" WHERE %s = %d", schema.getIdColumn(), id));

        //run our named template with the same attribute map
        if (namedTemplate != null ) {
            return namedTemplate.update(sql.toString(), attributes);
        }
        return 0;
    }

    public int delete(ISchema schema, Long id) {
        String sql = String.format("UPDATE %s SET Deleted = 1 WHERE %s = ?", schema.getName(), schema.getIdColumn());
        if(template != null ) {
            return template.update(sql, new Object[]{id});
        }
        return 0;
    }

}
