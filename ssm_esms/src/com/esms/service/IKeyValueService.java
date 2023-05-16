// 
// 
// 

package com.esms.service;

import com.esms.po.KeyValue;

public interface IKeyValueService
{
    KeyValue getKeyValueById(int p0) throws Exception;
    
    KeyValue selectBykvKey(String p0) throws Exception;
    
    int updateByPrimaryKey(KeyValue p0) throws Exception;
}
