package com.fag.infra.celcoin.mappers;

import com.fag.domain.dto.PixDTO;
import com.fag.infra.celcoin.dto.CelcoinPixDTO;

public class CelcoinPixMapper {
    
    public static PixDTO toAppDTO(CelcoinPixDTO vendorDTO) {
        PixDTO dto = new PixDTO();

        dto.setAmount(vendorDTO.getAmount());
        dto.setKey(vendorDTO.getKey());
        dto.setMerchant(CelcoinMerchantMapper.toAppDTO(vendorDTO.getMerchant()));

        return dto;
    }

    public static CelcoinPixDTO toVendorDTO(PixDTO appDTO) {
        CelcoinPixDTO dto = new CelcoinPixDTO();

        dto.setKey(appDTO.getKey());
        dto.setAmount(appDTO.getAmount());
        dto.setMerchant(CelcoinMerchantMapper.toVendorDTO(appDTO.getMerchant()));

        return dto;
    }
    
}
