// 
// 
// 

package com.esms.service;

import java.util.List;
import com.esms.po.Department;

public interface DepartmentService
{
    Department selectByPrimaryKey(int p0) throws Exception;
    
    int insertSelective(Department p0) throws Exception;
    
    void updateByPrimaryKeySelective(Department p0) throws Exception;
    
    void deleteByPrimaryKey(int p0) throws Exception;
    
    List<Department> findSelective(Department p0) throws Exception;
    
    void deleteByQuery(int[] p0);
    
    Department findByDname(String p0);
}
