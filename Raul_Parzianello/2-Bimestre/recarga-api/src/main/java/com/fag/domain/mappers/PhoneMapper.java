package com.fag.domain.mappers;

import com.fag.domain.dto.PhoneDTO;
import com.fag.domain.entities.PhoneBO;

public class PhoneMapper {
    public static PhoneDTO toDTO(PhoneBO bo) {
        PhoneDTO dto = new PhoneDTO();
        dto.setCountryCode(bo.getCountryCode());
        dto.setStateCode(bo.getStateCode());
        dto.setNumber(bo.getNumber());
        return dto;
    }

    public static PhoneBO toBO(PhoneDTO dto) {
        return new PhoneBO(
                dto.getStateCode(),
                dto.getCountryCode(),
                dto.getNumber());
    }
}
