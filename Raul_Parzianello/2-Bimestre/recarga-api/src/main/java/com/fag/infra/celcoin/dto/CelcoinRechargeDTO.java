package com.fag.infra.celcoin.dto;
public class CelcoinRechargeDTO {
    private String cpfcnpj;
    private Integer providerId;
    private CelcoinPhoneDTO phone;
    private CelcoinRechargeValueDTO topupData;

    public String getCpfcnpj() {
        return cpfcnpj;
    }

    public void setCpfcnpj(String cpfcnpj) {
        this.cpfcnpj = cpfcnpj;
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
