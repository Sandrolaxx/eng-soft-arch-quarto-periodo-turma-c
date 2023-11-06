package com.fag.infra.celcoin.dto;
public class CelcoinProductDTO {
    private Integer code;
    private Integer cost;
    private Integer dueProduct;
    private String productName;
    private Double minValue;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getDueProduct() {
        return dueProduct;
    }

    public void setDueProduct(Integer dueProduct) {
        this.dueProduct = dueProduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getMinValue() {
        return minValue;
    }

    public void setMinValue(Double minValue) {
        this.minValue = minValue;
    }

}
