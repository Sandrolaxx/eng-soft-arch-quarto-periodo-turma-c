package com.fag.domain.usecases;

import com.fag.domain.dto.PixDTO;
import com.fag.domain.entities.PixBO;
import com.fag.domain.mappers.PixMapper;
import com.fag.domain.repositories.IPixDatabaseRepository;
import com.fag.domain.repositories.IPixVendorRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreatePix {
  private IPixVendorRepository vendor;
  private IPixDatabaseRepository repository;

  public PixDTO execute(PixDTO dto) {
    PixBO bo = PixMapper.toBO(dto);

    PixDTO response = vendor.create(dto);

    repository.persist(bo);

    return response;
  }
}
