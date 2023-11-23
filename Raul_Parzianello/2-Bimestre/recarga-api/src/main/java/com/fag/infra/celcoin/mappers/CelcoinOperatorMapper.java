package com.fag.infra.celcoin.mappers;

import com.fag.domain.dto.OperatorDTO;
import com.fag.infra.celcoin.dto.CelcoinOperatorDTO;

public class CelcoinOperatorMapper {
    
    public static OperatorDTO toAppDto(CelcoinOperatorDTO vendorDTO) {
        OperatorDTO appDTO = new OperatorDTO();

        appDTO.setCategory(vendorDTO.getCategory());
        appDTO.setMaxValue(vendorDTO.getMaxValue());
        appDTO.setMinValue(vendorDTO.getMinValue());
        appDTO.setName(vendorDTO.getName());
        appDTO.setProviderID(vendorDTO.getProviderId());

        return appDTO;

    }
}
