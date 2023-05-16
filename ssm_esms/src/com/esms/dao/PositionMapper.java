// 
// 
// 

package com.esms.dao;

import java.util.List;
import com.esms.po.Position;

public interface PositionMapper
{
    int deleteByPrimaryKey(Integer p0);
    
    int insert(Position p0);
    
    int insertSelective(Position p0);
    
    Position selectByPrimaryKey(Integer p0);
    
    int updateByPrimaryKeySelective(Position p0);
    
    int updateByPrimaryKey(Position p0);
    
    List<Position> findSelective(Position p0);
    
    void deleteByQuery(int[] p0);
    
    Position findByDname(String p0);
}
