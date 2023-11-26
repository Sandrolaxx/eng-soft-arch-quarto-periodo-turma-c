package infra.celcoin.repository;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import infra.celcoin.dto.CelcoinOperatorsDTO;
import infra.celcoin.dto.CelcoinProductsDTO;
import infra.celcoin.dto.CelcoinRechargeDTO;
import infra.celcoin.dto.CelcoinRechargeResponseDTO;
import infra.celcoin.dto.CelcoinTokenDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Form;
import jakarta.ws.rs.core.MediaType;

@ApplicationScoped
@RegisterRestClient(baseUri = "https://sandbox.openfinance.celcoin.dev")
public interface RestClientCelcoin {

    @POST
    @Path("/v5/token")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    CelcoinTokenDTO generateToken(Form form);

    @GET
    @Path("/v5/transactions/topups/providers")
    CelcoinOperatorsDTO listOperators(@HeaderParam("Authorization") String token,
            @QueryParam("stateCode") Integer stateCode, @QueryParam("category") Integer category);

    @GET
    @Path("/v5/transactions/topups/provider-values")
    CelcoinProductsDTO listProducts(@HeaderParam("Authorization") String token,
            @QueryParam("stateCode") Integer stateCode, @QueryParam("providerId") Integer providerId);

    @GET
    @Path("/v5/transactions/topups")
    CelcoinRechargeResponseDTO handleRecharge(@HeaderParam("Authorization") String token, CelcoinRechargeDTO payload);
}