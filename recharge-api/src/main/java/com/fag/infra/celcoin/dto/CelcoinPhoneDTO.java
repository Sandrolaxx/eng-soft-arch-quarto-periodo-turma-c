package com.fag.infra.celcoin.dto;

public class CelcoinPhoneDTO {

    private Integer stateCode;
    private Integer countryCode;
    private String number;

    public Integer getStateCode() {
        return this.stateCode;
    }

    public void setStateCode(Integer stateCode) {
        this.stateCode = stateCode;
    }

    public Integer getCountryCode() {
        return this.countryCode;
    }

    public void setCountryCode(Integer countryCode) {
        this.countryCode = countryCode;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}