package com.fag.domain.dto;

public class OperatorDTO {
    private Integer category;
    private String name;
    private Integer providerID;
    private Double maxValue;
    private Double minValue;

    public void setCategory(Integer category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProviderID(Integer providerID) {
        this.providerID = providerID;
    }

    public void setMaxValue(Double maxValue) {
        this.maxValue = maxValue;
    }

    public void setMinValue(Double minValue) {
        this.minValue = minValue;
    }

    public Integer getCategory() {
        return category;
    }

    public String getname() {
        return name;
    }

    public Integer getProviderID() {
        return providerID;
    }

    public Double getMaxValue() {
        return maxValue;
    }

    public Double getMinValue() {
        return minValue;
    }

}
