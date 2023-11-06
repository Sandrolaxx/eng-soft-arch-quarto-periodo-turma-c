package com.fag.domain.dto;

public class ProductDTO {

    private String name;
    private Integer due;

    public void setName(String name) {
        this.name = name;
    }

    public void setDue(Integer due) {
        this.due = due;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Integer getDue() {
        return due;
    }

    public Double getValue() {
        return value;
    }

    private Double value;
}
