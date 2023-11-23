package com.fag.infra.celcoin.dto;

public class CelcoinRechargeDTO {
    
    private String cpfCnpj;

    private Integer providerId;

    private CelcoinPhoneDTO phone;

    private CelcoinRechargeValueDTO topupData;

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }

    public CelcoinPhoneDTO getPhone() {
        return phone;
    }

    public void setPhone(CelcoinPhoneDTO phone) {
        this.phone = phone;
    }

    public CelcoinRechargeValueDTO getTopupData() {
        return topupData;
    }

    public void setTopupData(CelcoinRechargeValueDTO topupData) {
        this.topupData = topupData;
    }
    
}
