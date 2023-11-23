package com.fag.domain.dto;

public class PhoneDTO {

    private Integer stateCode;
    private Integer countryCode;
    private String number;
    
    public Integer getStateCode() {
        return stateCode;
    }
    
    public Integer getCountryCode() {
        return countryCode;
    }
    
    public String getNumber() {
        return number;
    }

    public void setStateCode(Integer stateCode) {
        this.stateCode = stateCode;
    }

    public void setCountryCode(Integer countryCode) {
        this.countryCode = countryCode;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    
}
