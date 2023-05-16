// 
// 
// 

package com.esms.vo;

import com.esms.po.Department;
import com.esms.po.Position;
import com.esms.po.RankBonus;
import com.esms.po.Employee;

public class EmployeeCustomVo
{
    private Employee employee;
    private RankBonus rankBonus;
    private Position position;
    private Department department;
    
    public Employee getEmployee() {
        return this.employee;
    }
    
    public void setEmployee(final Employee employee) {
        this.employee = employee;
    }
    
    public RankBonus getRankBonus() {
        return this.rankBonus;
    }
    
    public void setRankBonus(final RankBonus rankBonus) {
        this.rankBonus = rankBonus;
    }
    
    public Position getPosition() {
        return this.position;
    }
    
    public void setPosition(final Position position) {
        this.position = position;
    }
    
    public Department getDepartment() {
        return this.department;
    }
    
    public void setDepartment(final Department department) {
        this.department = department;
    }
    
    @Override
    public String toString() {
        return "EmployeeCustomVo{employee=" + this.employee + ", rankBonus=" + this.rankBonus + ", position=" + this.position + ", department=" + this.department + '}';
    }
}
