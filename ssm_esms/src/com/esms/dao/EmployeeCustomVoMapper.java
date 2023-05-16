// 
// 
// 

package com.esms.dao;

import java.util.List;
import java.util.HashMap;
import com.esms.vo.EmployeeCustomVo;

public interface EmployeeCustomVoMapper
{
    EmployeeCustomVo selectEmployeeById(int p0);
    
    List<EmployeeCustomVo> selectEmployeeSelective(HashMap<String, Object> p0);
    
    EmployeeCustomVo selectVoByPrimaryKey(int p0);
}
