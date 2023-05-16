// 
// 
// 

package com.esms.vo;

public class EchSalaryPercent
{
    private String Department;
    private Double Salary;
    
    public String getDepartment() {
        return this.Department;
    }
    
    public void setDepartment(final String department) {
        this.Department = department;
    }
    
    public Double getSalary() {
        return this.Salary;
    }
    
    public void setSalary(final Double salary) {
        this.Salary = salary;
    }
    
    public EchSalaryPercent() {
        this.Department = null;
        this.Salary = 0.0;
    }
    
    public EchSalaryPercent(final String department, final Double salary) {
        this.Department = null;
        this.Salary = 0.0;
        this.Department = department;
        this.Salary = salary;
    }
}
