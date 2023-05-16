// 
// 
// 

package com.esms.vo;

import java.util.List;

public class EchDepartmentSalary
{
    private String department;
    private List<Double> salary;
    
    public String getDepartment() {
        return this.department;
    }
    
    public void setDepartment(final String department) {
        this.department = department;
    }
    
    public List<Double> getSalary() {
        return this.salary;
    }
    
    public void setSalary(final List<Double> salary) {
        this.salary = salary;
    }
}
