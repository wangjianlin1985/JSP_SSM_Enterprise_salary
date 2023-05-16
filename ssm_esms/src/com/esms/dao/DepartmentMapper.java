// 
// 
// 

package com.esms.dao;

import java.util.List;
import com.esms.po.Department;

public interface DepartmentMapper
{
    int deleteByPrimaryKey(Integer p0);
    
    int insert(Department p0);
    
    int insertSelective(Department p0);
    
    Department selectByPrimaryKey(Integer p0);
    
    List<Department> selectAll();
    
    int updateByPrimaryKeySelective(Department p0);
    
    int updateByPrimaryKey(Department p0);
    
    List<Department> findSelective(Department p0);
    
    void deleteByQuery(int[] p0);
    
    Department findByDname(String p0);
}
