// 
// 
// 

package com.esms.dao;

import java.util.List;
import java.util.Map;
import com.esms.po.MonthlyAttendance;

public interface MonthlyAttendanceMapper
{
    int deleteByPrimaryKey(Integer p0);
    
    int insert(MonthlyAttendance p0);
    
    int insertSelective(MonthlyAttendance p0);
    
    MonthlyAttendance selectByPrimaryKey(Integer p0);
    
    int updateByPrimaryKeySelective(MonthlyAttendance p0);
    
    int updateByPrimaryKey(MonthlyAttendance p0);
    
    MonthlyAttendance selectByeIdAndDate(int p0, String p1);
    
    void deleteByQuery(int[] p0);
    
    List<MonthlyAttendance> selectMonthlyAttendanceMapperByeEidAndTime(Map<String, Object> p0);
}
