package org.jsack.tifsa.core;

import org.jsack.tifsa.Database.Brand.Brand;
import org.jsack.tifsa.Database.Brand.BrandSchema;
import org.jsack.tifsa.Database.DBSelect;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by aaron on 3/21/17.
 */
public class BrandTest {
    private ApplicationContext context;
    @Test
    public void testSelectAll() {
        this.context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate template = new JdbcTemplate((DataSource)context.getBean("dataSource"));
        DBSelect<Brand> brandDBSelect = new DBSelect<>(template);
        List<Brand> brands = brandDBSelect.selectAll(new BrandSchema());
        brands.forEach( b -> System.out.println(b.getBrandName()));
    }
}
