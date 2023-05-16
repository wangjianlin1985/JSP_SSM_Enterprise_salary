// 
// 
// 

package com.esms.dao;

import java.util.List;
import com.esms.po.WorkingYearsBonus;

public interface WorkingYearsBonusMapper
{
    int deleteByPrimaryKey(Integer p0);
    
    int insert(WorkingYearsBonus p0);
    
    int insertSelective(WorkingYearsBonus p0);
    
    WorkingYearsBonus selectByPrimaryKey(Integer p0);
    
    int updateByPrimaryKeySelective(WorkingYearsBonus p0);
    
    int updateByPrimaryKey(WorkingYearsBonus p0);
    
    List<WorkingYearsBonus> selectAll();
    
    int countByYear(Integer p0);
    
    List<WorkingYearsBonus> findSelective(WorkingYearsBonus p0);
    
    WorkingYearsBonus findByYear(int p0);
}
