package com.fag.service;

import com.fag.domain.dto.PixDTO;
import com.fag.domain.repositories.IPixDataBaseRepository;
import com.fag.domain.usecases.CreatePixQRCode;
import com.fag.infra.celcoin.usecases.PixCelcoin;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class PixService {
  @Inject
  PixCelcoin celcoin;

  @Inject
  IPixDataBaseRepository panacheRepo;

  @Transactional
  public Response handlePix(PixDTO dto) {
    CreatePixQRCode createPix = new CreatePixQRCode(celcoin, panacheRepo);

    PixDTO createdPix = createPix.execute(dto);

    return Response.ok(createdPix).build();
  }
}
