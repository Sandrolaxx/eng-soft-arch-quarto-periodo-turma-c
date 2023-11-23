package com.fag.domain.dto;

public class RechargeDTO {
    
    private String id;
    private Double value;
    private String document;
    private Integer operatorId;
    private PhoneDTO phone;
    private String receipt;
    private long transactionId;
    private boolean success;
    
    public String getId() {
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
    
    public PhoneDTO getPhone() {
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

    public void setId(String id) {
        this.id = id;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public void setPhone(PhoneDTO phone) {
        this.phone = phone;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
    
    
}
