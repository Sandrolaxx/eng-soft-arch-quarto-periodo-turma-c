package br.com.fag.infra.celcoin.dto;

public class CelcoinTokenDTO {
  private String accessToken;
  private Integer expiresIn;
  private String tokenType;

  public CelcoinTokenDTO() {
  }

  public CelcoinTokenDTO(String accessToken, Integer expiresIn, String tokenType) {
    this.accessToken = accessToken;
    this.expiresIn = expiresIn;
    this.tokenType = tokenType;
  }

  public String getAccessToken() {
    return this.accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  public Integer getExpiresIn() {
    return this.expiresIn;
  }

  public void setExpiresIn(Integer expiresIn) {
    this.expiresIn = expiresIn;
  }

  public String getTokenType() {
    return this.tokenType;
  }

  public void setTokenType(String tokenType) {
    this.tokenType = tokenType;
  }

}