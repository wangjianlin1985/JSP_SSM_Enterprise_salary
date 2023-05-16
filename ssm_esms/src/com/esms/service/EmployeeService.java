// 
// 
// 

package com.esms.service;

import com.esms.po.Employee;

public interface EmployeeService
{
    void deleteByPrimaryKey(int p0);
    
    void deleteByQuery(int[] p0);
    
    void insert(Employee p0);
    
    Employee findByeAccount(String p0);
    
    void updateByPrimaryKeySelective(Employee p0);
}
