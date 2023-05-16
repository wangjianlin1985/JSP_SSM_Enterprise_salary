// 
// 
// 

package com.esms.service;

import com.esms.po.SystemManager;
import com.esms.exception.CustomException;
import com.esms.po.Employee;

public interface ILoginService
{
    Employee findEmployeeByIdAndPassword(String p0, String p1) throws CustomException;
    
    SystemManager findSystemManagerByIdAndPassword(String p0, String p1) throws CustomException;
    
    Employee findEmployeeById(int p0);
    
    SystemManager findSystemManagerById(int p0);
}
