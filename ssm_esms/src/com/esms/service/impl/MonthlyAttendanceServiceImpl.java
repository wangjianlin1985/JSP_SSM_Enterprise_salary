// 
// 
// 

package com.esms.service.impl;

import com.esms.po.MonthlyAttendance;
import org.springframework.beans.factory.annotation.Autowired;
import com.esms.dao.MonthlyAttendanceMapper;
import org.springframework.stereotype.Service;
import com.esms.service.IMonthlyAttendanceService;

@Service
public class MonthlyAttendanceServiceImpl implements IMonthlyAttendanceService
{
    @Autowired
    private MonthlyAttendanceMapper monthlyAttendanceMapper;
    
    public MonthlyAttendance t(final int id) {
        return this.monthlyAttendanceMapper.selectByPrimaryKey(id);
    }
    
    @Override
    public void deleteByPrimaryKey(final int id) {
        this.monthlyAttendanceMapper.deleteByPrimaryKey(id);
    }
    
    @Override
    public void deleteByQuery(final int[] ids) {
        this.monthlyAttendanceMapper.deleteByQuery(ids);
    }
    
    @Override
    public MonthlyAttendance selectByPrimaryKey(final int id) {
        return this.monthlyAttendanceMapper.selectByPrimaryKey(id);
    }
    
    @Override
    public void updateByPrimaryKeySelective(final MonthlyAttendance monthlyAttendance) {
        this.monthlyAttendanceMapper.updateByPrimaryKeySelective(monthlyAttendance);
    }
}
