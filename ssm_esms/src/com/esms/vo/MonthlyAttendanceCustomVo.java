// 
// 
// 

package com.esms.vo;

import com.esms.po.Department;
import com.esms.po.Employee;
import com.esms.po.MonthlyAttendance;

public class MonthlyAttendanceCustomVo
{
    private MonthlyAttendance monthlyAttendance;
    private Employee employee;
    private Department department;
    
    public MonthlyAttendanceCustomVo() {
        this.monthlyAttendance = null;
        this.employee = null;
        this.department = null;
    }
    
    @Override
    public String toString() {
        return "MonthlyAttendanceCustomVo{monthlyAttendance=" + this.monthlyAttendance + ", employee=" + this.employee + ", department=" + this.department + '}';
    }
    
    public MonthlyAttendance getMonthlyAttendance() {
        return this.monthlyAttendance;
    }
    
    public void setMonthlyAttendance(final MonthlyAttendance monthlyAttendance) {
        this.monthlyAttendance = monthlyAttendance;
    }
    
    public Employee getEmployee() {
        return this.employee;
    }
    
    public void setEmployee(final Employee employee) {
        this.employee = employee;
    }
    
    public Department getDepartment() {
        return this.department;
    }
    
    public void setDepartment(final Department department) {
        this.department = department;
    }
}
