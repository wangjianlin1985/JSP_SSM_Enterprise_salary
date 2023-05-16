// 
// 
// 

package com.esms.service;

import java.util.List;
import com.esms.po.RankBonus;

public interface IRankBonusService
{
    boolean addRankBonus(RankBonus p0);
    
    boolean moveRankBonus(int p0);
    
    boolean modifyRankName(RankBonus p0);
    
    List<RankBonus> findAll();
    
    RankBonus findById(int p0);
    
    RankBonus findByName(String p0);
    
    int CountByRbid(Integer p0);
    
    int CountByName(String p0);
    
    List<RankBonus> findSelective(RankBonus p0) throws Exception;
}
