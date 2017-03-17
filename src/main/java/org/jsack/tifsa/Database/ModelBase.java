package org.jsack.tifsa.Database;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by aaron on 3/14/17.
 */
public abstract class ModelBase {
    private ApplicationContext context;
    private JdbcTemplate template;
    private NamedParameterJdbcTemplate namedTemplate;

    public ModelBase() {
        String dataSource = System.getenv("dataSource");

        // set default data source bean
        if(dataSource == null) {
            dataSource = "dataSource";
        }

        this.context = new ClassPathXmlApplicationContext("applicationContext.xml");
        setTemplate((javax.sql.DataSource)this.context.getBean(dataSource));
        setNamedTemplate(new NamedParameterJdbcTemplate(this.getTemplate()));
    }

    public void setTemplate(DataSource ds) {

        this.template = new JdbcTemplate(ds);
    }
    public JdbcTemplate getTemplate() {

        return this.template;
    }
    public NamedParameterJdbcTemplate getNamedTemplate() {
        return namedTemplate;
    }

    public void setNamedTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedTemplate = namedParameterJdbcTemplate;
    }

}
