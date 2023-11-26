package com.fag.domain.entities;

import java.util.UUID;

public class PixQrcodeBO {
  private Double amount;
  private String qrCode;
  private Long transactionId;
  private UUID id;
  private String key;

  public PixQrcodeBO(UUID id, String key, Double amount, String qrCode, Long transactionId) {
    this.amount = amount;
    this.qrCode = qrCode;
    this.transactionId = transactionId;
    this.id = id != null ? id : UUID.randomUUID();
    this.key = key;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public String getQrCode() {
    return qrCode;
  }

  public void setQrCode(String qrCode) {
    this.qrCode = qrCode;
  }

  public Long getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(Long transactionId) {
    this.transactionId = transactionId;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }
}
