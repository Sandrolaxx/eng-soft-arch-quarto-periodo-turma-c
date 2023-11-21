package com.fag.infra.celcoin.usecases;


import com.fag.domain.dto.PixDTO;
import com.fag.domain.repositories.IPixVendor;
import com.fag.infra.celcoin.dto.CelcoinPixDTO;
import com.fag.infra.celcoin.dto.CelcoinPixResponse;
import com.fag.infra.celcoin.dto.CelcoinTokenDTO;
import com.fag.infra.celcoin.mappers.CelcoinPixMapper;
import com.fag.infra.celcoin.services.RestClientCelcoin;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Form;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class PixCelcoin implements IPixVendor {
    @Inject
    @RestClient
    RestClientCelcoin restClientCelcoin;

    @Override
    public PixDTO create(PixDTO pixDTO){
        CelcoinPixDTO pixDTO1 = CelcoinPixMapper.toVendoDTO(pixDTO);

        CelcoinPixResponse response = restClientCelcoin.handlePix(getToken(), pixDTO1);

        pixDTO.setQrCode(response.getQrCode());
        pixDTO.setTransactionId(response.getTransactionId());

        return pixDTO;
    }

    private String getToken() {
        Form form = new Form();

        form.param("client_id", "41b44ab9a56440.teste.celcoinapi.v5");
        form.param("grant_type", "client_credentials");
        form.param("client_secret", "e9d15cde33024c1494de7480e69b7a18c09d7cd25a8446839b3be82a56a044a3");

        CelcoinTokenDTO tokenDTO = restClientCelcoin.generateToken(form);

        return "Bearer " + tokenDTO.getAccessToken();
    }
}
