package com.fag.domain.mappers;

import com.fag.domain.dto.MerchantDTO;
import com.fag.domain.entities.MerchantBO;

public class MerchantMapper {
  public static MerchantBO toBO(MerchantDTO dto) {
    return new MerchantBO(
        dto.getPostalCode(),
        dto.getCity(),
        dto.getMerchantCategoryCode(),
        dto.getName());
  }

  public static MerchantDTO toDTO(MerchantBO bo) {
    MerchantDTO dto = new MerchantDTO();

    dto.setPostalCode(bo.getPostalCode());
    dto.setCity(bo.getCity());
    dto.setMerchantCategoryCode(bo.getMerchantCategoryCode());
    dto.setName(bo.getName());

    return dto;
  }
}