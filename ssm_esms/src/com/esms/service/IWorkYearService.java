// 
// 
// 

package com.esms.service;

import java.util.List;
import com.esms.po.WorkingYearsBonus;

public interface IWorkYearService
{
    boolean addWorkYearBonus(WorkingYearsBonus p0);
    
    boolean moveWorkYearBonus(int p0);
    
    boolean modifyWorkYearBonus(WorkingYearsBonus p0);
    
    List<WorkingYearsBonus> findAll();
    
    WorkingYearsBonus findById(int p0);
    
    int Count(int p0);
    
    List<WorkingYearsBonus> findSelective(WorkingYearsBonus p0);
    
    WorkingYearsBonus findByYear(int p0);
}
