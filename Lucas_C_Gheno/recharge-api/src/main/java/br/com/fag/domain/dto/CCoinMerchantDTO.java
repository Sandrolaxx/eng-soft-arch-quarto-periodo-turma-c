package br.com.fag.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CCoinMerchantDTO {
    private String postalCode;
    private String city;
    private Integer categoryCode;
    private String name;
}