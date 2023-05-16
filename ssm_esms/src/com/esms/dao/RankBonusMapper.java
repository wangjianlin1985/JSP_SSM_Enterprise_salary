// 
// 
// 

package com.esms.dao;

import java.util.List;
import com.esms.po.RankBonus;

public interface RankBonusMapper
{
    int deleteByPrimaryKey(Integer p0);
    
    int insert(RankBonus p0);
    
    int insertSelective(RankBonus p0);
    
    RankBonus selectByPrimaryKey(Integer p0);
    
    List<RankBonus> selectAll();
    
    int updateByPrimaryKeySelective(RankBonus p0);
    
    int updateByPrimaryKey(RankBonus p0);
    
    int CountByRankName(String p0);
    
    List<RankBonus> findSelective(RankBonus p0);
    
    RankBonus findByname(String p0);
}
