// 
// 
// 

package com.esms.vo;

import java.util.List;

public class EchMonthSalary
{
    private String year;
    private List<Double> salary;
    
    public String getYear() {
        return this.year;
    }
    
    public void setYear(final String year) {
        this.year = year;
    }
    
    public List<Double> getSalary() {
        return this.salary;
    }
    
    public void setSalary(final List<Double> salary) {
        this.salary = salary;
    }
    
    public EchMonthSalary() {
    }
    
    public EchMonthSalary(final String year, final List<Double> salary) {
        this.year = year;
        this.salary = salary;
    }
}
