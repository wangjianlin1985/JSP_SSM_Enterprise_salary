// 
// 
// 

package com.esms.service.impl;

import com.esms.po.KeyValue;
import org.springframework.beans.factory.annotation.Autowired;
import com.esms.dao.KeyValueMapper;
import org.springframework.stereotype.Service;
import com.esms.service.IKeyValueService;

@Service
public class KeyValueServiceImpl implements IKeyValueService
{
    @Autowired
    private KeyValueMapper keyValueMapper;
    
    public KeyValueServiceImpl() {
        this.keyValueMapper = null;
    }
    
    @Override
    public KeyValue getKeyValueById(final int id) throws Exception {
        return this.keyValueMapper.selectByPrimaryKey(id);
    }
    
    @Override
    public KeyValue selectBykvKey(final String key) throws Exception {
        return this.keyValueMapper.selectBykvKey(key);
    }
    
    @Override
    public int updateByPrimaryKey(final KeyValue kv) throws Exception {
        return this.keyValueMapper.updateByPrimaryKey(kv);
    }
}
