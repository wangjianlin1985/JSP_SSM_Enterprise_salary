// 
// 
// 

package com.esms.dao;

import com.esms.po.KeyValue;

public interface KeyValueMapper
{
    int deleteByPrimaryKey(Integer p0);
    
    int insert(KeyValue p0);
    
    int insertSelective(KeyValue p0);
    
    KeyValue selectByPrimaryKey(Integer p0);
    
    int updateByPrimaryKeySelective(KeyValue p0);
    
    int updateByPrimaryKey(KeyValue p0);
    
    KeyValue selectBykvKey(String p0);
}
