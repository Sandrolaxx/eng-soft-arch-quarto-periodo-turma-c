package com.fag.infra.panache.models;

import java.util.UUID;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "AKT_PIX_CODE")
public class PanachePixCode extends PanacheEntityBase {

  @Id
  private UUID id;

  @Column(name = "TRANSACTION_ID")
  private Long transactionId;

  @Column(name = "EMV")
  private String emvqrcps;

  @Column(name = "KEY")
  private String key;

  @Column(name = "AMOUNT")
  private Double amount;

  public UUID getId() {
    return this.id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Long getTransactionId() {
    return this.transactionId;
  }

  public void setTransactionId(Long transactionId) {
    this.transactionId = transactionId;
  }

  public String getEmvqrcps() {
    return this.emvqrcps;
  }

  public void setEmvqrcps(String emvqrcps) {
    this.emvqrcps = emvqrcps;
  }

  public String getKey() {
    return this.key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public Double getAmount() {
    return this.amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

}
