// 
// 
// 

package com.esms.service;

import com.esms.po.MonthlyAttendance;

public interface IMonthlyAttendanceService
{
    void deleteByPrimaryKey(int p0);
    
    void deleteByQuery(int[] p0);
    
    MonthlyAttendance selectByPrimaryKey(int p0);
    
    void updateByPrimaryKeySelective(MonthlyAttendance p0);
}
