// 
// 
// 

package com.esms.po;

public class WorkingYearsBonus
{
    private Integer wybId;
    private Integer wybYear;
    private Double wybBonus;
    
    public Integer getWybId() {
        return this.wybId;
    }
    
    public void setWybId(final Integer wybId) {
        this.wybId = wybId;
    }
    
    public Integer getWybYear() {
        return this.wybYear;
    }
    
    public void setWybYear(final Integer wybYear) {
        this.wybYear = wybYear;
    }
    
    public Double getWybBonus() {
        return this.wybBonus;
    }
    
    public void setWybBonus(final Double wybBonus) {
        this.wybBonus = wybBonus;
    }
    
    @Override
    public String toString() {
        return "WorkingYearsBonus{wybId=" + this.wybId + ", wybYear=" + this.wybYear + ", wybBonus=" + this.wybBonus + '}';
    }
}
