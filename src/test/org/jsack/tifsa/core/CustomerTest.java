package org.jsack.tifsa.core;

import org.jsack.tifsa.Database.Customer.CustomerWrapper;
import org.jsack.tifsa.Database.Customer.Customer;
import org.jsack.tifsa.Database.Customer.CustomerDAO;
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
    @Test
    public void testCustomerDAOSelectAll(){
        CustomerDAO cust = new CustomerDAO();
        List<Customer> customers = cust.selectAll();
        customers.forEach(c -> System.out.println(c.getFullName()));
        assert(!customers.isEmpty());
    }

    @Test
    public void testCustomerDAOFindByNameExclusive() {
        CustomerDAO cust = new CustomerDAO();
        List<Customer> customers = cust.findByName("Aaron", "Rubesh", true);
        customers.forEach( c -> System.out.println(c.getFullName()));
        assert(!customers.isEmpty());
    }

    @Test
    public void testCustomerDAOFindByNameInclusive() {
        CustomerDAO cust = new CustomerDAO();
        List<Customer> customers = cust.findByName("", "Rubesh", false);
        customers.forEach( c -> System.out.println(c.getFullName()));
        assert(!customers.isEmpty());
    }

    @Test
    public void testCustomerDAOFindById() {
        CustomerDAO cust = new CustomerDAO();
        Customer c = cust.findById(1);
        System.out.println(c.toString());
        assert(c != null);
    }
}