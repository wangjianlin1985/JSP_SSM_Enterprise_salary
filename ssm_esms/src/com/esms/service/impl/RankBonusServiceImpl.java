// 
// 
// 

package com.esms.service.impl;

import java.util.List;
import com.esms.po.RankBonus;
import com.esms.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.esms.dao.RankBonusMapper;
import org.springframework.stereotype.Service;
import com.esms.service.IRankBonusService;

@Service("rankBonusService")
public class RankBonusServiceImpl implements IRankBonusService
{
    @Autowired
    private RankBonusMapper rankBonusMapper;
    @Autowired
    private EmployeeMapper employeeMapper;
    
    @Override
    public int CountByRbid(final Integer rbid) {
        final int n = this.employeeMapper.countByRbid(rbid);
        if (n > 0) {
            return n;
        }
        return 0;
    }
    
    public void setRankBonusMapper(final RankBonusMapper rankBonusMapper) {
        this.rankBonusMapper = rankBonusMapper;
    }
    
    @Override
    public boolean moveRankBonus(final int rbId) {
        final int n = this.rankBonusMapper.deleteByPrimaryKey(rbId);
        return n > 0;
    }
    
    @Override
    public boolean modifyRankName(final RankBonus rb) {
        final int n = this.rankBonusMapper.updateByPrimaryKey(rb);
        return n > 0;
    }
    
    @Override
    public List<RankBonus> findAll() {
        final List<RankBonus> rb = this.rankBonusMapper.selectAll();
        if (rb.size() > 0) {
            return rb;
        }
        return null;
    }
    
    @Override
    public RankBonus findById(final int rbId) {
        return null;
    }
    
    @Override
    public RankBonus findByName(final String rankName) {
        return this.rankBonusMapper.findByname(rankName);
    }
    
    @Override
    public boolean addRankBonus(final RankBonus rb) {
        final int count = this.rankBonusMapper.insert(rb);
        return count > 0;
    }
    
    public int CountByRbid(final int rbId) {
        final int count = this.employeeMapper.countByRbid(rbId);
        if (count > 0) {
            return count;
        }
        return 0;
    }
    
    @Override
    public int CountByName(final String name) {
        final int count = this.rankBonusMapper.CountByRankName(name);
        if (count > 0) {
            return count;
        }
        return 0;
    }
    
    @Override
    public List<RankBonus> findSelective(final RankBonus rb) {
        return this.rankBonusMapper.findSelective(rb);
    }
}
