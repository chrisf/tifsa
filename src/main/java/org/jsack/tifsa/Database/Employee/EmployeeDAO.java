package org.jsack.tifsa.Database.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by aaron on 3/16/17.
 */
public class EmployeeDAO extends EmployeeBase{
    @Override
    public List<Employee> selectAll() {
        String sql = "SELECT * From Employee";
        List<Employee> employees = getTemplate().query(sql, new EmployeeWrapper());
        return employees;
    }

    @Override
    public int update(Employee employee) {
        String sql = "UPDATE Employee " +
                     "SET EmployeeFirst = :first, EmployeeMiddleInitial = :mid, EmployeeLast = :last " +
                     "WHERE EmployeeID = :id";

        Map<String,Object> attributes = new HashMap<>();
        attributes.put("first", employee.getEmployeeFirst());
        attributes.put("mid", employee.getEmployeeMiddleInitial());
        attributes.put("last", employee.getEmployeeLast());
        attributes.put("id", employee.getEmployeeId());

       return getNamedTemplate().update(sql, attributes);
    }

    @Override
    public int delete(Employee employee) {
        String sql = "DELETE FROM Employee WHERE EmployeeID = ?";
        return getTemplate().update(sql, new Object[]{ employee.getEmployeeId() });
    }

    @Override
    public Employee create(String employeeFirst, String employeeMiddleInitial, String employeeLast) {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("EmployeeFirst", employeeFirst);
        attributes.put("EmployeeMiddleInitial", employeeMiddleInitial);
        attributes.put("EmployeeLast", employeeLast);

        Number id = getSimpleInsert().executeAndReturnKey(attributes);
        return getById(id.intValue());
    }

    @Override
    public Employee getById(int id){
       String sql = "SELECT * FROM Employee WHERE EmployeeID = ?";
       return getTemplate().queryForObject(sql, new Object[]{id}, new EmployeeWrapper());
    }
}
