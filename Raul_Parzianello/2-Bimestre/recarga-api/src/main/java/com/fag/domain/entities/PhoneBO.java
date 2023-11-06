package com.fag.domain.entities;

public class PhoneBO {

    private String countryCode;

    private String stateCode;

    private String number;

    public PhoneBO(String countryCode, String stateCode, String number) {
        this.countryCode = countryCode;
        this.stateCode = stateCode;
        this.number = number;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getStateCode() {
        return stateCode;
    }

    public String getNumber() {
        return number;
    }

}
