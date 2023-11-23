package com.fag.domain.entities;

import java.util.UUID;

public class PixBO {
    
    private UUID id;
    
    private String key;

    private Double amount;

    private String qrCode;

    private Long transactionId;

    public UUID getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    public Double getAmount() {
        return amount;
    }

    public String getQrCode() {
        return qrCode;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public PixBO(UUID id, String key, Double amount, String qrCode, Long transactionId) {
        this.id = id;
        this.key = key;
        this.amount = amount;
        this.qrCode = qrCode;
        this.transactionId = transactionId;
    }


    
}
