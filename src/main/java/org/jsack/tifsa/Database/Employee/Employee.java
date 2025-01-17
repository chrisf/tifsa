package org.jsack.tifsa.Database.Employee;

/**
 * Created by aaron on 3/16/17.
 */
public class Employee {
    private int employeeId;
    private String employeeFirst;
    private String employeeMiddleInitial;
    private String employeeLast;
    private boolean deleted;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeFirst() {
        return employeeFirst;
    }

    public void setEmployeeFirst(String employeeFirst) {
        this.employeeFirst = employeeFirst;
    }

    public String getEmployeeMiddleInitial() {
        return employeeMiddleInitial;
    }

    public void setEmployeeMiddleInitial(String employeeMiddleInitial) {
        this.employeeMiddleInitial = employeeMiddleInitial;
    }

    public String getEmployeeLast() {
        return employeeLast;
    }

    public void setEmployeeLast(String employeeLast) {
        this.employeeLast = employeeLast;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
    public String toString() { return String.format("%s %s",this.employeeFirst, this.employeeLast); }
}
