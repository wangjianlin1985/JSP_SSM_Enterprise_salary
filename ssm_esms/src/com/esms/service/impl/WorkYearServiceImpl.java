// 
// 
// 

package com.esms.service.impl;

import java.util.List;
import com.esms.po.WorkingYearsBonus;
import org.springframework.beans.factory.annotation.Autowired;
import com.esms.dao.WorkingYearsBonusMapper;
import org.springframework.stereotype.Service;
import com.esms.service.IWorkYearService;

@Service
public class WorkYearServiceImpl implements IWorkYearService
{
    @Autowired
    private WorkingYearsBonusMapper workingYearsBonusMapper;
    
    @Override
    public boolean addWorkYearBonus(final WorkingYearsBonus wyb) {
        final int count = this.workingYearsBonusMapper.insert(wyb);
        return count > 0;
    }
    
    @Override
    public boolean moveWorkYearBonus(final int wybId) {
        final int n = this.workingYearsBonusMapper.deleteByPrimaryKey(wybId);
        return n > 0;
    }
    
    @Override
    public boolean modifyWorkYearBonus(final WorkingYearsBonus wyb) {
        final int n = this.workingYearsBonusMapper.updateByPrimaryKey(wyb);
        return n > 0;
    }
    
    @Override
    public List<WorkingYearsBonus> findAll() {
        final List<WorkingYearsBonus> wyb = this.workingYearsBonusMapper.selectAll();
        if (wyb.size() > 0) {
            return wyb;
        }
        return null;
    }
    
    @Override
    public WorkingYearsBonus findById(final int wybId) {
        return null;
    }
    
    @Override
    public int Count(final int wybYear) {
        final int n = this.workingYearsBonusMapper.countByYear(wybYear);
        if (n > 0) {
            return n;
        }
        return 0;
    }
    
    @Override
    public List<WorkingYearsBonus> findSelective(final WorkingYearsBonus record) {
        return this.workingYearsBonusMapper.findSelective(record);
    }
    
    @Override
    public WorkingYearsBonus findByYear(final int year) {
        return this.workingYearsBonusMapper.findByYear(year);
    }
}
