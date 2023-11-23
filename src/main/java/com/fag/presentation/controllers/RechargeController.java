package com.fag.presentation.controllers;

import com.fag.domain.dto.RechargeDTO;
import com.fag.service.RechargeService;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/v1/recharge")
public class RechargeController {

  @Inject
  RechargeService service;

  @GET
  @Path("/operators")
  @Produces(MediaType.APPLICATION_JSON)
  public Response listOperators(@HeaderParam("stateCode") Integer stateCode,
      @HeaderParam("category") Integer category) {
    return service.listOperators(stateCode, category);
  }

  @GET
  @Path("/products")
  @Produces(MediaType.APPLICATION_JSON)
  public Response listProducts(@HeaderParam("stateCode") Integer stateCode,
      @HeaderParam("operatorId") Integer operatorId) {
    return service.listProducts(stateCode, operatorId);
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  public Response handleRecharge(RechargeDTO dto) {
    return service.handleRecharge(dto);
  }

}
