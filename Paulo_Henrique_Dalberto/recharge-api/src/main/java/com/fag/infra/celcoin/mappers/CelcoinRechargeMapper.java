package com.fag.infra.celcoin.mappers;

import com.fag.domain.dto.RechargeDTO;
import com.fag.infra.celcoin.dto.recharge.CelcoinRechargeDTO;
import com.fag.infra.celcoin.dto.recharge.CelcoinRechargeValueDTO;

public class CelcoinRechargeMapper {
  public static CelcoinRechargeDTO toVendorDTO(RechargeDTO appDTO){
    CelcoinRechargeDTO vendorDTO = new CelcoinRechargeDTO();
    CelcoinRechargeValueDTO toUpData = new CelcoinRechargeValueDTO();

    toUpData.setValue(appDTO.getValue());

    vendorDTO.setCpfCpnj(appDTO.getDocument());
    vendorDTO.setPhone(CelcoinRechargePhoneMapper.toVendorDTO(appDTO.getPhone()));
    vendorDTO.setProviderId(appDTO.getOperatorId());
    vendorDTO.setTopupData(toUpData);

    return vendorDTO;
  }
}
