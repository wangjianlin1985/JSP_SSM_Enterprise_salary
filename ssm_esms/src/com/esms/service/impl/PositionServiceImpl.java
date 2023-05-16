// 
// 
// 

package com.esms.service.impl;

import java.util.List;
import com.esms.po.Position;
import org.springframework.beans.factory.annotation.Autowired;
import com.esms.dao.PositionMapper;
import org.springframework.stereotype.Service;
import com.esms.service.PositionService;

@Service
public class PositionServiceImpl implements PositionService
{
    @Autowired
    public PositionMapper positionMapper;
    
    public PositionServiceImpl() {
        this.positionMapper = null;
    }
    
    @Override
    public List<Position> findSelective(final Position position) {
        return this.positionMapper.findSelective(position);
    }
    
    @Override
    public int insertSelective(final Position position) {
        return this.positionMapper.insertSelective(position);
    }
    
    @Override
    public Position findByPrimaryKey(final int id) {
        return this.positionMapper.selectByPrimaryKey(id);
    }
    
    @Override
    public void updateByPrimaryKeySelective(final Position position) {
        this.positionMapper.updateByPrimaryKeySelective(position);
    }
    
    @Override
    public void deleteByPrimaryKey(final int id) {
        this.positionMapper.deleteByPrimaryKey(id);
    }
    
    @Override
    public void deleteByQuery(final int[] ids) {
        this.positionMapper.deleteByQuery(ids);
    }
    
    @Override
    public Position findByDname(final String p_name) {
        return this.positionMapper.findByDname(p_name);
    }
}
