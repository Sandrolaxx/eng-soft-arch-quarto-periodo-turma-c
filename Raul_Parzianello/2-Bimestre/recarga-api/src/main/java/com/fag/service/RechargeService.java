package com.fag.service;

import java.util.List;

import com.fag.domain.dto.OperatorDTO;
import com.fag.domain.dto.ProductDTO;
import com.fag.domain.dto.RechargeDTO;
import com.fag.domain.usecases.CreateRecharge;
import com.fag.domain.usecases.ListOperators;
import com.fag.domain.usecases.ListProducts;
import com.fag.infra.celcoin.repository.RechargeCelcoin;
import com.fag.infra.panache.repository.PanacheDataBaseRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class RechargeService {

    @Inject
    RechargeCelcoin celcoin;

    @Inject
    PanacheDataBaseRepository panacheRepo;

    public Response listOperators(Integer stateCode, Integer category) {
        ListOperators listOperators = new ListOperators(celcoin);

        List<OperatorDTO> operators = listOperators.execute(stateCode, category);

        return Response.ok(operators).build();
    }

    public Response listProducs(Integer stateCode, Integer operatorId) {
        ListProducts listServices = new ListProducts(celcoin);

        List<ProductDTO> operators = listServices.execute(stateCode, operatorId);

        return Response.ok(operators).build();
    }

    @Transactional
    public Response handleRecharge(RechargeDTO dto) {
        CreateRecharge createRecharge = new CreateRecharge(celcoin, panacheRepo);

        RechargeDTO createdRecharge = createRecharge.execute(dto);

        return Response.ok(createdRecharge).build();
    }

}
