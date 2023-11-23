package com.fag.domain.dto;

public class PhoneDTO {

    private String countryCode;

    private String stateCode;

    private String number;

    public String getCountryCode() {
        return countryCode;
    }

    public String getStateCode() {
        return stateCode;
    }

    public String getNumber() {
        return number;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
