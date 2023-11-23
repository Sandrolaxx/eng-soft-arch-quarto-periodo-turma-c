package com.fag.domain.entities;

import java.util.UUID;

public class RechargeBO {

    private UUID id;

    private Double value;

    private String document;

    private Integer providerId;

    private PhoneBO phone;

    private String receipt;

    private Long transactionId;

    private boolean success;

    public RechargeBO(UUID id, Double value, String document, Integer providerId, PhoneBO phone,
            String receipt, Long transactionId, boolean success) {
        this.id = id != null ? id : UUID.randomUUID();
        this.value = value;
        this.document = document;
        this.providerId = providerId;
        this.phone = phone;
        this.receipt = receipt;
        this.transactionId = transactionId;
        this.success = success;

        validate();
    }

    public void handleSuccess(String receipt, Long transactionId) {
        this.receipt = receipt;
        this.transactionId = transactionId;
        this.success = true;
    }

    public void handleError() {
        this.success = false;
    }

    private void validate() {

        if (this.value == null) {
            throw new RuntimeException("Campo obrigatório - Value");
        }

        if (this.document == null || this.document.isEmpty()) {
            throw new RuntimeException("Campo obrigatório - Document");
        }

        if (this.phone == null) {
            throw new RuntimeException("Campo obrigatório - Phone");
        }

    }

    public Double getValue() {
        return value;
    }

    public String getDocument() {
        return document;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public PhoneBO getPhone() {
        return phone;
    }

    public UUID getId() {
        return id;
    }

    public String getReceipt() {
        return receipt;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public boolean isSuccess() {
        return success;
    }

}