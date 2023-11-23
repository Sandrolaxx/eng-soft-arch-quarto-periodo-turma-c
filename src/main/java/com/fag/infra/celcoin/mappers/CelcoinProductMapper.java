package com.fag.infra.celcoin.mappers;

import com.fag.domain.dto.ProductDTO;
import com.fag.infra.celcoin.dto.CelcoinProductDTO;

public class CelcoinProductMapper {
    
    public static ProductDTO toAppDto(CelcoinProductDTO vendorDTO) {
        ProductDTO appDTO = new ProductDTO();

        appDTO.setName(vendorDTO.getProductName());
        appDTO.setValue(vendorDTO.getMinValue());
        appDTO.setDue(vendorDTO.getDueProduct());

        return appDTO;
    }
}
