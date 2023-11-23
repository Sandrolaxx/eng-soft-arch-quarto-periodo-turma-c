package com.fag.infra.celcoin.mappers;

import com.fag.domain.dto.OperatorDTO;
import com.fag.infra.celcoin.dto.CelcoinOperatorDTO;

public class CelcoinOperatorMapper {
    
    public static OperatorDTO toAppDTO(CelcoinOperatorDTO vendorDTO) {
        OperatorDTO appDTO = new OperatorDTO();

        appDTO.setCategory(vendorDTO.getCategory());
        appDTO.setMaxValue(vendorDTO.getMaxValue());
        appDTO.setMinValue(vendorDTO.getMinValue());
        appDTO.setName(vendorDTO.getName());
        appDTO.setOperatorId(vendorDTO.getProviderId());
        
        return appDTO;
    }
}
