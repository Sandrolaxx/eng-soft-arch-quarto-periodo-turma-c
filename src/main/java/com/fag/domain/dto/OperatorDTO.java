package com.fag.domain.dto;

public class OperatorDTO{
    
    private Integer category;
    private String name;
    private Integer operatorId;
    private Double maxValue;
    private Double minValue;


    public Integer getCategory() {
        return category;
    }
    
    public String getName() {
        return name;
    }
    
    public Integer getOperatorId() {
        return operatorId;
    }
    
    public Double getMaxValue() {
        return maxValue;
    }
    
    public Double getMinValue() {
        return minValue;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public void setMaxValue(Double maxValue) {
        this.maxValue = maxValue;
    }

    public void setMinValue(Double minValue) {
        this.minValue = minValue;
    }
    
    

}