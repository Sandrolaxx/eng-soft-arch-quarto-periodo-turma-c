package com.fag.infra.celcoin.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.fag.domain.dto.OperatorDTO;
import com.fag.domain.dto.ProductDTO;
import com.fag.domain.dto.RechargeDTO;
import com.fag.domain.repositories.IRechargeVendor;
import com.fag.infra.celcoin.dto.CelcoinOperatorsDTO;
import com.fag.infra.celcoin.dto.CelcoinProductsDTO;
import com.fag.infra.celcoin.dto.CelcoinRechargeDTO;
import com.fag.infra.celcoin.dto.CelcoinRechargeResponseDTO;
import com.fag.infra.celcoin.dto.CelcoinTokenDTO;
import com.fag.infra.celcoin.mappers.CelcoinOperatorMapper;
import com.fag.infra.celcoin.mappers.CelcoinProductMapper;
import com.fag.infra.celcoin.mappers.CelcoinRechargeMapper;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Form;

@ApplicationScoped
public class RechargeCelcoin implements IRechargeVendor {

    @Inject
    @RestClient
    RestClientCelcoin restClient;

    @Override
    public RechargeDTO createRecharge(RechargeDTO recharge) {
        try {
            CelcoinRechargeDTO rechargeDTO = CelcoinRechargeMapper.toVendorDTO(recharge);

            CelcoinRechargeResponseDTO response = restClient.handleRecharge(getToken(), rechargeDTO);

            recharge.setReceipt(response.getReceipt().getReceiptData());

            recharge.setTransactionId(response.getTransactionId());

            recharge.setSuccess(response.getErrorCode().equals("000"));

        } catch (Exception e) {
            throw new RuntimeException("Erro comunicação com o provedor do serviço de recarga");
        }

        return recharge;
    }

    @Override
    public List<OperatorDTO> listOperators(Integer stateCode, Integer category) {

        try {
            CelcoinOperatorsDTO operators = restClient.listOperators(getToken(), stateCode, category);

            return operators.getProviders().stream()
                    .map(item -> CelcoinOperatorMapper.toAppDto(item))
                    .collect(Collectors.toList());
        }

        catch (Exception e) {
            throw new RuntimeException("Erro comunicação provedor servico recarga", e);
        }

    }

    @Override
    public List<ProductDTO> listProducts(Integer operatorId, Integer stateCode) {
        try {
            CelcoinProductsDTO Products = restClient.listProducts(getToken(), stateCode, operatorId);

            return Products.getProducts().stream()
                    .map(item -> CelcoinProductMapper.toAppDto(item))
                    .collect(Collectors.toList());
        }

        catch (Exception e) {
            throw new RuntimeException("Erro comunicação provedor servico recarga", e);
        }
    }

    private String getToken() {

        Form form = new Form();

        form.param("client_id", "41b44ab9a56440.test.celcoinapi.v5");
        form.param("grant_type", "client_credentials");
        form.param("client_secret", "e9d15cde33024c1494de7480e69b7a18c09d7cd25a8446839b3be82a56a044a3");

        CelcoinTokenDTO tokenDTO = restClient.generateToken(form);

        String token = "Bearer" + tokenDTO.getAccessToken();

        return token;

    }
}