package org.jsack.tifsa.Database;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;

/**
 * Created by aaron on 3/14/17.
 */
public abstract class ModelBase {
    private ApplicationContext context;
    private JdbcTemplate template;
    private NamedParameterJdbcTemplate namedTemplate;
    private SimpleJdbcInsert simpleInsert;

    public ModelBase() {
        String dataSource = System.getenv("dataSource");
        if(dataSource == null){
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
}
