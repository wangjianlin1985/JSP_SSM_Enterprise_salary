// 
// 
// 

package com.esms.dao;

import java.util.Map;
import java.util.List;
import com.esms.vo.EchSalary;
import com.esms.po.Salary;

public interface SalaryMapper
{
    int deleteByPrimaryKey(Integer p0);
    
    int insert(Salary p0);
    
    int insertSelective(Salary p0);
    
    Salary selectByPrimaryKey(Integer p0);
    
    int updateByPrimaryKeySelective(Salary p0);
    
    int updateByPrimaryKey(Salary p0);
    
    Salary selectByEidAndTime(Integer p0, String p1);
    
    Double selectMaxSalaryByDepartment(Integer p0, String p1);
    
    EchSalary selectSalaryByDepartment(Integer p0, String p1);
    
    Double selectAllSalaryByDepartment(Integer p0, String p1);
    
    Double selectAllSalaryByDepAndYear(Integer p0, String p1);
    
    List<Salary> selectEmployeeSalaryList(Integer p0, String p1);
    
    List<Salary> selectByeId(Integer p0);
    
    Double selectAllSalaryByDate(String p0);
    
    List<Salary> test(String p0);
    
    List<Salary> selectByEaccountDIdDate(Map<String, Object> p0);
    
    List<Salary> selectByeTimeAndStatus(String p0, int p1);
    
    Salary selectByEidAndTimeAndStatus(Integer p0, String p1, int p2);
    
    List<Salary> selectByEaccountDIdDateState(Map<String, Object> p0);
}
