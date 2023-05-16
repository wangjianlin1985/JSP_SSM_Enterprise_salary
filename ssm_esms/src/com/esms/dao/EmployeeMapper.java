// 
// 
// 

package com.esms.dao;

import java.util.List;
import com.esms.po.Employee;

public interface EmployeeMapper
{
    int deleteByPrimaryKey(Integer p0);
    
    int insert(Employee p0);
    
    int insertSelective(Employee p0);
    
    Employee selectByPrimaryKey(Integer p0);
    
    int updateByPrimaryKeySelective(Employee p0);
    
    int updateByPrimaryKey(Employee p0);
    
    Employee selectByAccountAndPassword(Employee p0);
    
    int countByDid(Integer p0);
    
    int countByRbid(Integer p0);
    
    Employee selectByAccount(String p0);
    
    Employee findByeAccount(String p0);
    
    List<Employee> selectAll();
    
    int isExistEmployee(String p0);
    
    int selectEidByEaccount(String p0);
}
