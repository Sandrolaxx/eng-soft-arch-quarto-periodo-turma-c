package com.fag.infra.celcoin.mappers;
import com.fag.domain.dto.RechargeDTO;
import com.fag.infra.celcoin.dto.CelcoinPhoneDTO;
import com.fag.infra.celcoin.dto.CelcoinRechargeDTO;
import com.fag.infra.celcoin.dto.CelcoinRechargeValueDTO;

public class CelcoinRechargeMapper {
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
    public static CelcoinRechargeDTO toVendorDTO(RechargeDTO recharge) {
        return null;
    }

}
