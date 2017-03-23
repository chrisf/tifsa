package org.jsack.tifsa.core;

import org.jsack.tifsa.Database.Customer.Customer;
import org.jsack.tifsa.Database.Customer.CustomerDAO;
import org.jsack.tifsa.Database.Customer.CustomerWrapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        customers.forEach(c -> System.out.println(c.toString()));
        assert(!customers.isEmpty());
    }

    @Test
    public void testCustomerDAOFindByNameExclusive() {
        CustomerDAO cust = new CustomerDAO();
        List<Customer> customers = cust.selectByName("Aaron", "Rubesh", true);
        customers.forEach( c -> System.out.println(c.getFullName()));
        assert(!customers.isEmpty());
    }

    @Test
    public void testCustomerDAOFindByNameInclusive() {
        CustomerDAO cust = new CustomerDAO();
        List<Customer> customers = cust.selectByName("", "Rubesh", false);
        customers.forEach( c -> System.out.println(c.getFullName()));
        assert(!customers.isEmpty());
    }

    @Test
    public void testCustomerDAOFindById() {
        CustomerDAO cust = new CustomerDAO();
        Customer c = cust.selectById(1);
        System.out.println(c.toString());
        assert(c != null);
    }

    @Test
    public void testCreateCustomer() {
        Customer c = new Customer();
        CustomerDAO customerDAO = new CustomerDAO();

        c.setCustomerFirst("Test1");
        c.setCustomerLast("Test1");
        c.setCustomerBillingFirst("Test1");
        c.setCustomerBillingLast("Test2");
        c.setStateId(1);
        c.setCustomerTypeId(1);
        c.setCustomerStatusId(1);
        System.out.println(c.getCustomerAddedOn());

        long id = customerDAO.create(c);

        System.out.println(id);
        assert(id > 0);
        customerDAO.delete(id);
    }

    @Test
    public void testCustomerUpdate() {
        CustomerDAO customerDAO = new CustomerDAO();
        Customer first = new Customer();

        first.setCustomerFirst("FirstName1");
        first.setCustomerLast("LastName1");
        first.setCustomerBillingFirst("FirstName1");
        first.setCustomerBillingLast("LastName1");
        first.setStateId(1);
        first.setCustomerTypeId(1);
        first.setCustomerStatusId(1);

        long id  = customerDAO.create(first);

        Map<String, Object> attributes = new HashMap<>();
        attributes.put("CustomerFirst", "FirstName2");

        customerDAO.update(id, attributes);

        Customer second = customerDAO.selectById(id);

        assert(second.getCustomerFirst().equals("FirstName2"));
        customerDAO.delete(id);
    }
}