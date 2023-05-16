// 
// 
// 

package com.esms.po;

public class RankBonus
{
    private Integer rbId;
    private String rankName;
    private Integer rbBonus;
    
    public Integer getRbId() {
        return this.rbId;
    }
    
    public void setRbId(final Integer rbId) {
        this.rbId = rbId;
    }
    
    public String getRankName() {
        return this.rankName;
    }
    
    public void setRankName(final String rankName) {
        this.rankName = ((rankName == null) ? null : rankName.trim());
    }
    
    public Integer getRbBonus() {
        return this.rbBonus;
    }
    
    public void setRbBonus(final Integer rbBonus) {
        this.rbBonus = rbBonus;
    }
    
    @Override
    public String toString() {
        return "RankBonus{rbId=" + this.rbId + ", rankName='" + this.rankName + '\'' + ", rbBonus=" + this.rbBonus + '}';
    }
}
