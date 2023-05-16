// 
// 
// 

package com.esms.vo;

public class EchSalary
{
    private Double minSalary;
    private Double avgSalary;
    private Double maxSalary;
    
    public Double getMinSalary() {
        return this.minSalary;
    }
    
    public void setMinSalary(final Double minSalary) {
        this.minSalary = minSalary;
    }
    
    public Double getAvgSalary() {
        return this.avgSalary;
    }
    
    public void setAvgSalary(final Double avgSalary) {
        this.avgSalary = avgSalary;
    }
    
    public Double getMaxSalary() {
        return this.maxSalary;
    }
    
    public void setMaxSalary(final Double maxSalary) {
        this.maxSalary = maxSalary;
    }
    
    public EchSalary() {
        this.minSalary = 0.0;
        this.avgSalary = 0.0;
        this.maxSalary = 0.0;
    }
    
    public EchSalary(final Double minSalary, final Double avgSalary, final Double maxSalary) {
        this.minSalary = 0.0;
        this.avgSalary = 0.0;
        this.maxSalary = 0.0;
        this.minSalary = minSalary;
        this.avgSalary = avgSalary;
        this.maxSalary = maxSalary;
    }
}
