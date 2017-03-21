package org.jsack.tifsa.core;

import org.jsack.tifsa.Database.Employee.Employee;
import org.jsack.tifsa.Database.Employee.EmployeeDAO;
import org.junit.Test;

/**
 * Created by aaron on 3/16/17.
 */
public class EmployeeTest {
    @Test
    public void createTest(){
        EmployeeDAO dao = new EmployeeDAO();
        Employee e = dao.create("Aaron", "D", "Rubesh");
        if(e != null) {
            assert(true);
            dao.delete(e);
        }
    }

    @Test
    public void deleteTest(){
        EmployeeDAO dao = new EmployeeDAO();
        Employee e = dao.create("Aaron", "D", "Rubesh");
        if(e != null) {
            int affectedRows = dao.delete(e);
            if(affectedRows > 0) {
                assert(true);
            }
        }
    }

    @Test
    public void updateTest(){
        EmployeeDAO dao = new EmployeeDAO();
        Employee e = dao.create("Aaron", "D", "Rubesh");
        if(e != null) {
            e.setEmployeeLast("New Last Name");
           if(dao.update(e) > 0) {
               assert(true);
           }
            dao.delete(e);
        }
    }

    @Test
    public void getByIdTest(){
        EmployeeDAO dao = new EmployeeDAO();
        Employee e = dao.create("Aaron", "D", "Rubesh");
        if(e != null) {
            if(dao.getById(e.getEmployeeId()) != null)
            {
               assert(true);
            }
            dao.delete(e);
        }
    }
}
