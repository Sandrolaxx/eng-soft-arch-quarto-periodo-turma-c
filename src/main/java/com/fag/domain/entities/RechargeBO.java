package com.fag.domain.entities;

import java.util.UUID;

public class RechargeBO {
    
    private UUID id;
    private Double value;
    private String document;
    private Integer operatorId;
    private PhoneBO phone;
    private String receipt;
    private long transactionId;
    private boolean success;
    
    public UUID getId() {
        return id;
    }

    public Double getValue() {
        return value;
    }

    public String getDocument() {
        return document;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public PhoneBO getPhone() {
        return phone;
    }

    public String getReceipt() {
        return receipt;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public boolean isSuccess() {
        return success;
    }

    public RechargeBO(UUID id, Double value, String document, Integer operatorId, PhoneBO phone, String receipt,
            long transactionId, boolean success) {
        this.id = id;
        this.value = value;
        this.document = document;
        this.operatorId = operatorId;
        this.phone = phone;
        this.receipt = receipt;
        this.transactionId = transactionId;
        this.success = success;
    }

    public void handleSuccess(String receipt, Long transactionId) {
        this.receipt= receipt;
        this.transactionId = transactionId;
        this.success = true;
    }

    public void handleError() {
        this.success = false;
    }

    
}
