package com.fag.domain.mappers;

import java.util.UUID;

import com.fag.domain.dto.PixDTO;
import com.fag.domain.entities.PixBO;

public class PixMapper {
    
    public static PixBO toBO(PixDTO dto) {
        return new PixBO(dto.getId() != null ? UUID.fromString(dto.getId()) : null, dto.getKey(), dto.getAmount(),
            dto.getQrCode(), dto.getTransactionId());
    }

    public static PixDTO toDTO(PixBO bo) {
        PixDTO dto = new PixDTO();

        dto.setId(bo.getId() != null ? bo.getId().toString() : null);
        dto.setKey(bo.getKey());
        dto.setAmount(bo.getAmount());
        dto.setQrCode(bo.getQrCode());
        dto.setTransactionId(bo.getTransactionId());

        return dto;
        
    }
}
