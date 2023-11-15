package com.fag.controllers;

import com.fag.domain.dto.RechargeDTO;
import com.fag.service.RechargeService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/recharge")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RechargeController {

    @Inject
    RechargeService rechargeService;

    @GET
    @Path("/operators")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listOperators(@HeaderParam("stateCode") Integer stateCode, @HeaderParam("category") Integer category) {
        return rechargeService.listOperators(stateCode, category);
    }

    @GET
    @Path("/products")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listProducts(@HeaderParam("stateCode") Integer stateCode, @HeaderParam("operatorId") Integer operatorId) {
        return rechargeService.listProducts(stateCode, operatorId);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response handleRecharge(RechargeDTO dto) {
        return rechargeService.handleRecharge(dto);
    }

}
