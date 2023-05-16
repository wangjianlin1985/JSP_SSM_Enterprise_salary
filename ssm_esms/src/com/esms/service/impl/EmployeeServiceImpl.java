// 
// 
// 

package com.esms.service.impl;

import java.util.Date;
import com.esms.po.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import com.esms.dao.EmployeeMapper;
import org.springframework.stereotype.Service;
import com.esms.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
    @Autowired
    private EmployeeMapper employeeMapper;
    
    @Override
    public void deleteByPrimaryKey(final int id) {
        this.employeeMapper.deleteByPrimaryKey(id);
    }
    
    @Override
    public void deleteByQuery(final int[] ids) {
        for (final int i : ids) {
            final Employee employee = new Employee();
            employee.seteId(i);
            employee.seteLeaveTime(new Date());
            employee.seteIsdel(0);
            this.employeeMapper.updateByPrimaryKeySelective(employee);
        }
    }
    
    @Override
    public void insert(final Employee employee) {
        this.employeeMapper.insert(employee);
    }
    
    @Override
    public Employee findByeAccount(final String eAccount) {
        return this.employeeMapper.findByeAccount(eAccount);
    }
    
    @Override
    public void updateByPrimaryKeySelective(final Employee employee) {
        this.employeeMapper.updateByPrimaryKeySelective(employee);
    }
}
