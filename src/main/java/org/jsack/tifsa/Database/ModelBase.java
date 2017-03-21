package org.jsack.tifsa.Database;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by aaron on 3/14/17.
 */
public abstract class ModelBase {
    private ApplicationContext context;
    private JdbcTemplate template;
    private NamedParameterJdbcTemplate namedTemplate;
    private SimpleJdbcInsert simpleInsert;

    public ModelBase() {
        String dataSource = System.getProperty("dataSource");

        // set default data source bean
        if(dataSource == null) {
            dataSource = "dataSource";
        }

        this.context = new ClassPathXmlApplicationContext("applicationContext.xml");
        setTemplate((javax.sql.DataSource)this.context.getBean(dataSource));
    }
    public void setTemplate(DataSource ds) {
        this.template = new JdbcTemplate(ds);
        setNamedTemplate(new NamedParameterJdbcTemplate(this.getTemplate()));
    }
    public JdbcTemplate getTemplate() {
        return this.template;
    }
    public NamedParameterJdbcTemplate getNamedTemplate() {
        return namedTemplate;
    }
    public SimpleJdbcInsert getSimpleInsert() {
        return simpleInsert;
    }
    public void setSimpleInsert(String tableName, String primaryColumnName) {
        this.simpleInsert = new SimpleJdbcInsert(template).withTableName(tableName).usingGeneratedKeyColumns(primaryColumnName);
    }
    public void setNamedTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedTemplate = namedParameterJdbcTemplate;
    }

    public int delete(String table, String column, long id) {
        // create delete statement
        String sql = "DELETE FROM ?" +
                     "WHERE ? = ?";

        // execute sql statement and return rows affected
        return this.getTemplate().update(sql, new Object[] { table, column, id});
    }

    public int update(String table, String idColumn, long id, HashMap<String, Object> attributes) {
        //creates our initial sql statement
        StringBuilder sql = new StringBuilder(String.format("UPDATE %s SET ", table));

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
        sql.append(String.format(" WHERE %s = %d", idColumn, id));

        //run our named template with the same attribute map
        return this.getNamedTemplate().update(sql.toString(), attributes);
    }
}
