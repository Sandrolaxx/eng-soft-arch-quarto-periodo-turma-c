package br.com.fag.infra.celcoin.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import br.com.fag.domain.dto.OperatorDTO;
import br.com.fag.domain.dto.ProductDTO;
import br.com.fag.domain.dto.RechargeDTO;
import br.com.fag.domain.repositories.IRechargeVendorRepository;
import br.com.fag.infra.celcoin.dto.CelcoinOperatorsDTO;
import br.com.fag.infra.celcoin.dto.CelcoinProductsDTO;
import br.com.fag.infra.celcoin.dto.CelcoinRechargeDTO;
import br.com.fag.infra.celcoin.dto.CelcoinRechargeResponseDTO;
import br.com.fag.infra.celcoin.dto.CelcoinTokenDTO;
import br.com.fag.infra.celcoin.mappers.CelcoinOperatorMapper;
import br.com.fag.infra.celcoin.mappers.CelcoinProductMapper;
import br.com.fag.infra.celcoin.mappers.CelcoinRechargeMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Form;

@ApplicationScoped
public class RechargeCelcoin implements IRechargeVendorRepository {

  @Inject
  @RestClient
  RestClientCelcoin restClient;

  @Override
  public RechargeDTO create(RechargeDTO recharge) {
    try {
      CelcoinRechargeDTO rechargeDTO = CelcoinRechargeMapper.toVendorDTO(recharge);
      CelcoinRechargeResponseDTO response = restClient.handleRecharge(getToken(), rechargeDTO);

      recharge.setReceipt(response.getReceipt().getReceiptData());
      recharge.setTransactionId(response.getTransactionId());
      recharge.setSuccess(response.getErrorCode().equals("000"));
    } catch (Exception e) {
      throw new RuntimeException("Erro de comunicação com o provedor do serviço");
    }

    return recharge;
  }

  @Override
  public List<OperatorDTO> listOperators(Integer stateCode, Integer category) {
    try {
      CelcoinOperatorsDTO operators = restClient.listOperators(getToken(), stateCode, category);

      return operators.getProviders().stream().map(operator -> CelcoinOperatorMapper.toAppDTO(operator)).collect(Collectors.toList());
    } catch (Exception e) {
      throw new RuntimeException("Erro de comunicação com o provedor do serviço");
    }
  }

  @Override
  public List<ProductDTO> listProducts(Integer stateCode, Integer operatorId) {
    try {
      CelcoinProductsDTO products = restClient.listProducts(getToken(), stateCode, operatorId);

      return products.getProducts().stream().map(product -> CelcoinProductMapper.toAppDTO(product)).collect(Collectors.toList());
    } catch (Exception e) {;
      throw new RuntimeException("Erro de comunicação com o provedor do serviço");
    }
  }
  
  private String getToken() {
    Form form = new Form();

    form.param("client_id", "");
    form.param("grant_type", "client_credentials");
    form.param("client_secret", "");

    CelcoinTokenDTO tokenDTO = restClient.generateToken(form);
    String token = "Bearer " + tokenDTO.getAccessToken();

    return token;
  }
}