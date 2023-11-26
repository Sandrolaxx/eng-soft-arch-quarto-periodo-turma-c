package org.example.infra.celcoin.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Form;
import org.example.domain.dto.OperatorDTO;
import org.example.domain.dto.ProductDTO;
import org.example.domain.dto.RechargeDTO;
import org.example.domain.repositories.IRechargeVendor;
import org.example.infra.celcoin.dto.*;
import org.example.infra.celcoin.mappers.CelcoinOperatorMapper;
import org.example.infra.celcoin.mappers.CelcoinProductMapper;
import org.example.infra.celcoin.mappers.CelcoinRechargeMapper;
import org.example.infra.celcoin.repository.RestClientCelcoin;
import org.eclipse.microprofile.rest.client.inject.RestClient;


import java.security.cert.CertificateEncodingException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@ApplicationScoped
public class RechargeCelcoin implements IRechargeVendor {
    @Inject
    @RestClient
    RestClientCelcoin restClient;
    @Override
    public RechargeDTO create(RechargeDTO recharge) {

        try {
            CelcoinRechargeDTO rechargeDTO = CelcoinRechargeMapper.toVendorDTO(recharge);

            CelcoinRechargeResponseDTO response = restClient.handleRecharge(getToken(), rechargeDTO);

            recharge.setReceipt(response.getReceipt().getReceiptData());
            recharge.setTransactionId(response.getTransactionld());
            recharge.setSuccess(response.getErrorCode().equals("000"));
        }catch (Exception e) {
            throw new RuntimeException("Erro comunicação provedor servico recarga");
        }

        return recharge;
    }

    @Override
    public List<OperatorDTO> listOperators(Integer stateCode, Integer category) {
        try {
            CelcoinOperatorsDTO operators = restClient.listOperators(getToken(),stateCode,category);

            return operators.getProviders().stream().map(operator -> CelcoinOperatorMapper.toAppDTO(operator)).collect(Collectors.toList());
        }catch (Exception e) {
            throw new RuntimeException("Erro comunicação provedor servico recarga");
        }
    }

    @Override
    public List<ProductDTO> listProducts(Integer stateCode, Integer operatorId) {
        try {
            CelcoinProductsDTO products = restClient.listProducts(getToken(),stateCode,operatorId);

            return products.getProcucts().stream().map(product -> CelcoinProductMapper.toAppDTO(product)).collect(Collectors.toList());
        }catch (Exception e) {
            throw new RuntimeException("Erro comunicação provedor servico recarga");
        }
    }

    private String getToken() {
        Form form = new Form();

        form.param("client_id", "41b44ab9a56440.teste.celcoinapi.v5");
        form. param( "grant_type","client_credentials");
        form. param( "client_secret", "e9d15cde33024c1494de7480e69b7a18c09d7cd25a8446839b3be82a56a044a3");

        CelcoinTokenDTO tokenDTO = restClient . generateToken( form);
        String token = "Bearer" + tokenDTO.getAccessToken();

        return token;
    }

}
