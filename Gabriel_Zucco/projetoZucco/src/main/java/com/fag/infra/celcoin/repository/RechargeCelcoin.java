package main.java.com.fag.infra.celcoin.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Form;
import java.util.List;
import java.util.stream.Collectors;

import main.java.com.fag.domain.dto.OperatorDTO;
import main.java.com.fag.domain.dto.ProductDTO;
import main.java.com.fag.domain.dto.RechargeDTO;
import main.java.com.fag.infra.celcoin.dto.CelcoinOperatorsDTO;
import main.java.com.fag.infra.celcoin.dto.CelcoinProductsDTO;
import main.java.com.fag.infra.celcoin.dto.CelcoinRechargeDTO;
import main.java.com.fag.infra.celcoin.dto.CelcoinRechargeResponseDTO;
import main.java.com.fag.infra.celcoin.dto.CelcoinTokenDTO;
import main.java.com.fag.infra.celcoin.mappers.CelcoinOperatorMapper;
import main.java.com.fag.infra.celcoin.mappers.CelcoinProductMapper;
import main.java.com.fag.infra.celcoin.mappers.CelcoinRechargeMapper;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class RechargeCelcoin implements IRechargeVendor {

    @Inject
    @RestClient
    RestClientCelcoin restClient;

    
    public RechargeDTO create(RechargeDTO recharge){

        try{
            CelcoinRechargeDTO rechargeDTO = CelcoinRechargeMapper.toVendorDTO(recharge);

            CelcoinRechargeResponseDTO response = restClient.handleRecharge(GetToken(), rechargeDTO);

            recharge.setReceipt(response.getReceipt().getReceiptData());
            recharge.setTransactionId(response.getTransactionID());
            recharge.setSuccess(response.getErrorCode().equals("000"));
        } catch (Exception e) {
            throw new RuntimeException ("Erro Comunicação provedor serviço recarga.");
        }

        return recharge;
    }

    
    public List<OperatorDTO> listOperators(Integer stateCode, Integer category){

        try{
            CelcoinOperatorsDTO operators = restClient.listOperators(GetToken(), stateCode, category);

            return operators.getProviders().stream()
                    .map(operator -> CelcoinOperatorMapper.toAppDTO(operator))
                    .collect(Collectors.toList());
        } catch (Exception e){
            throw new RuntimeException("Erro Comunicação provedor serviço recarga.", e);
        }
    }


    public List<ProductDTO> listProducts(Integer operatorID, Integer stateCode){
        try{
            CelcoinProductsDTO products = restClient.listProducts(GetToken(), stateCode, operatorID);

            return products.getProducts().stream()
                    .map(product -> CelcoinProductMapper.toAppDTO(product))
                    .collect(Collectors.toList());
        } catch (Exception e){
            throw new RuntimeException("Erro Comunicação provedor serviço recarga.");
        }
    }

    private String GetToken(){
        Form form = new Form();

        form.param("client_id", "41b44ab9a56440.teste.celcoinapi.v5");
        form.param("grant_type", "client_credentials");
        form.param("client_secret", "e9d15cde33024c1494de7480e69b7a18c09d7cd25a8446839b3be82a56a944a3");

        CelcoinTokenDTO tokenDTO = restClient.generateToken(form);
        String token = "Bearer" + tokenDTO.getAcessToken();

        return token;
    }
}