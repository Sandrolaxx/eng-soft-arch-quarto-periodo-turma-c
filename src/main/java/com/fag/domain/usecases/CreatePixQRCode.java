package com.fag.domain.usecases;

import com.fag.domain.dto.PixDTO;
import com.fag.domain.entities.PixBO;
import com.fag.domain.mappers.PixMapper;
import com.fag.domain.repositories.IPixDataBaseRepository;
import com.fag.domain.repositories.IPixVendor;

public class CreatePixQRCode {

    private IPixVendor vendor;
    private IPixDataBaseRepository repository;

    public CreatePixQRCode(IPixVendor vendor, IPixDataBaseRepository repository){
        this.vendor = vendor;
        this.repository = repository;
    }

    public PixDTO execute(PixDTO dto) {
        PixBO bo = PixMapper.toBO(dto);

        PixDTO response = vendor.create(dto);

        repository.persist(bo);

        return response;
    }
    
}