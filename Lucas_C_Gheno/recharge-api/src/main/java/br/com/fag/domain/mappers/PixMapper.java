package br.com.fag.domain.mappers;


import br.com.fag.domain.dto.CCoinPixDTO;
import br.com.fag.domain.dto.CCoinPixDTO;

import java.util.UUID;

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