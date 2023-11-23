package com.fag.domain.dto;

public class ProductDTO {
    
    private String name;
    private Double value;
    private Integer due;

    public String getName() {
        return name;
    }
   
    public Double getValue() {
        return value;
    }
    
    public Integer getDue() {
        return due;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public void setDue(Integer due) {
        this.due = due;
    }
    
}
