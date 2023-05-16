// 
// 
// 

package com.esms.po;

public class KeyValue
{
    private Integer kvId;
    private String kvKey;
    private double kvValue;
    
    public Integer getKvId() {
        return this.kvId;
    }
    
    public void setKvId(final Integer kvId) {
        this.kvId = kvId;
    }
    
    public String getKvKey() {
        return this.kvKey;
    }
    
    public void setKvKey(final String kvKey) {
        this.kvKey = ((kvKey == null) ? null : kvKey.trim());
    }
    
    public double getKvValue() {
        return this.kvValue;
    }
    
    public void setKvValue(final double kvValue) {
        this.kvValue = kvValue;
    }
    
    @Override
    public String toString() {
        return "KeyValue{kvId=" + this.kvId + ", kvKey='" + this.kvKey + '\'' + ", kvValue='" + this.kvValue + '\'' + '}';
    }
}
