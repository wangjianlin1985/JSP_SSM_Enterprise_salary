// 
// 
// 

package com.esms.service;

import com.esms.vo.EchMonthSalary;
import com.esms.vo.EchSalaryPercent;
import com.esms.vo.EchDepartmentSalary;
import com.esms.vo.EchEmployeeNums;
import java.util.List;
import java.util.Map;

public interface IEchartsService
{
    Map<String, List<EchEmployeeNums>> getEmployeeNums();
    
    Map<String, List<EchDepartmentSalary>> getDepartmentSalary(String p0);
    
    Map<String, List<EchSalaryPercent>> getSalaryPercent(String p0, int p1);
    
    Map<String, List<EchMonthSalary>> getMonthSalary();
}
