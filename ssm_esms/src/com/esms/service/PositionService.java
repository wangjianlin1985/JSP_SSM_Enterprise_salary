// 
// 
// 

package com.esms.service;

import java.util.List;
import com.esms.po.Position;

public interface PositionService
{
    List<Position> findSelective(Position p0);
    
    int insertSelective(Position p0);
    
    Position findByPrimaryKey(int p0);
    
    void updateByPrimaryKeySelective(Position p0);
    
    void deleteByPrimaryKey(int p0);
    
    void deleteByQuery(int[] p0);
    
    Position findByDname(String p0);
}
