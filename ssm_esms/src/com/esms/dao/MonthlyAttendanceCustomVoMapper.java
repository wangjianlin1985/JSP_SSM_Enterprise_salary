// 
// 
// 

package com.esms.dao;

import com.esms.vo.MonthlyAttendanceCustomVo;
import java.util.List;
import java.util.Map;

public interface MonthlyAttendanceCustomVoMapper
{
    List<MonthlyAttendanceCustomVo> selectMonthlyAttendanceCustomVoMapperByeAccountAnddIdAndTime(Map<String, Object> p0);
    
    MonthlyAttendanceCustomVo selectVoByPrimaryKey(int p0);
}
