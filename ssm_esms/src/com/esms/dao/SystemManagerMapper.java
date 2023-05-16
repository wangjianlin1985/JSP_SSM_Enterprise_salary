// 
// 
// 

package com.esms.dao;

import com.esms.po.SystemManager;

public interface SystemManagerMapper
{
    int deleteByPrimaryKey(Integer p0);
    
    int insert(SystemManager p0);
    
    int insertSelective(SystemManager p0);
    
    SystemManager selectByPrimaryKey(Integer p0);
    
    int updateByPrimaryKeySelective(SystemManager p0);
    
    int updateByPrimaryKey(SystemManager p0);
    
    SystemManager selectByAccountAndPassword(SystemManager p0);
}
