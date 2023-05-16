// 
// 
// 

package com.esms.service;

import com.esms.po.Salary;
import java.util.List;
import com.esms.po.Employee;
import com.esms.vo.EmployeeCustomVo;
import com.esms.exception.CustomException;
import com.esms.po.SystemManager;

public interface IUserInforService
{
    void updateSystemManagePassword(int p0, SystemManager p1);
    
    void updateEmployeePassword(int p0, String p1, String p2) throws CustomException;
    
    EmployeeCustomVo getInforEmployee(int p0);
    
    int updateEmploueeById(int p0, Employee p1);
    
    List<Salary> getEmployeeSalaryList(int p0, String p1);
}
