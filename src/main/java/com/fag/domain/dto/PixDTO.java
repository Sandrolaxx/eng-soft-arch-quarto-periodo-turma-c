package com.fag.domain.dto;

public class PixDTO {

    private String id;

    private Double amount;

    private String qrCode;
    
    private String key;

    private MerchantDTO merchant;

    private Long transactionId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public MerchantDTO getMerchant() {
        return merchant;
    }

    public void setMerchant(MerchantDTO merchant) {
        this.merchant = merchant;
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

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }
}
