package com.fag.presentantion.controllers;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/v1/recharge")
public class RechargeController {

    @Inject
    RechargeService service;

    @GET
    @Path("/operators")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listOperators(@HeaderParam("stateCode") Integer stateCode, @HeaderParam("category") Integer category) {
                return service.listOperators(stateCode,category);
    }

    @GET
    @Path("/products")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listProducs(@HeaderParam("stateCode") Integer stateCode, @HeaderParam("operatorId") Integer operatorId) {
        return service.listProducs(stateCode,operatorId);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response handleRecharge(RechargeDTO dto) {
        return service.handleRecharge(dto);
    }
}

