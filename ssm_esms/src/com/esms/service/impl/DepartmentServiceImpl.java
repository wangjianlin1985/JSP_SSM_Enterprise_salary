// 
// 
// 

package com.esms.service.impl;

import java.util.List;
import com.esms.po.Department;
import org.springframework.beans.factory.annotation.Autowired;
import com.esms.dao.DepartmentMapper;
import org.springframework.stereotype.Service;
import com.esms.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService
{
    @Autowired
    public DepartmentMapper departmentMapper;
    
    public DepartmentServiceImpl() {
        this.departmentMapper = null;
    }
    
    @Override
    public Department selectByPrimaryKey(final int id) {
        return this.departmentMapper.selectByPrimaryKey(id);
    }
    
    @Override
    public int insertSelective(final Department department) {
        return this.departmentMapper.insertSelective(department);
    }
    
    @Override
    public void updateByPrimaryKeySelective(final Department department) {
        this.departmentMapper.updateByPrimaryKeySelective(department);
    }
    
    @Override
    public void deleteByPrimaryKey(final int id) {
        this.departmentMapper.deleteByPrimaryKey(id);
    }
    
    @Override
    public List<Department> findSelective(final Department department) {
        return this.departmentMapper.findSelective(department);
    }
    
    @Override
    public void deleteByQuery(final int[] ids) {
        this.departmentMapper.deleteByQuery(ids);
    }
    
    @Override
    public Department findByDname(final String d_name) {
        return this.departmentMapper.findByDname(d_name);
    }
}
