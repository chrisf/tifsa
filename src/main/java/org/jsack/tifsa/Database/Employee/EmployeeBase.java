package org.jsack.tifsa.Database.Employee;

import org.jsack.tifsa.Database.ModelBase;

import java.util.List;

/**
 * Created by aaron on 3/16/17.
 */
public abstract class EmployeeBase extends ModelBase
{
    public EmployeeBase(){
        setSimpleInsert("Employee", "EmployeeID");
    }
    public abstract List<Employee> selectAll();
    public abstract int update(Employee employee);
    public abstract int delete(Employee employee);
    public abstract Employee create(String employeeFirst, String employeeMiddleInitial, String employeeLast);
    public abstract Employee getById(int id);
}
