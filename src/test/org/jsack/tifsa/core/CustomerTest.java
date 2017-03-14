package org.jsack.tifsa.core;

import org.jsack.tifsa.DBModelWrappers.CustomerWrapper;
import org.jsack.tifsa.DBModels.Customer;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Created by aaron on 3/1/17.
 */


public class CustomerTest {
    @Test
    public void testStandardCustomer() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate template = new JdbcTemplate((javax.sql.DataSource) context.getBean("dataSource"));
        String sql = "SELECT * FROM Customer";
        List<Customer> customers = template.query(sql, new CustomerWrapper());

        if (customers.size() > 0) {
            for (Customer c : customers) {
                System.out.println(c.getCustomerFirst());
            }
            assert (true);
        } else {
            assert (false);
        }
    }
}