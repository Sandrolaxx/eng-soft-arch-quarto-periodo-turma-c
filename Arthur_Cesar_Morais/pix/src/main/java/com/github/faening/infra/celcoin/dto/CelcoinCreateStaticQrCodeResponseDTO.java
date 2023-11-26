package com.github.faening.infra.celcoin.dto;

public class CelcoinCreateStaticQrCodeResponseDTO {
    private Long transactionId;
    private String emvqrcps;
    private String transactionIdentification;

    public CelcoinCreateStaticQrCodeResponseDTO(Long transactionId, String emvqrcps, String transactionIdentification) {
        this.transactionId = transactionId;
        this.emvqrcps = emvqrcps;
        this.transactionIdentification = transactionIdentification;
    }

    public CelcoinCreateStaticQrCodeResponseDTO() {}

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public String getEmvqrcps() {
        return emvqrcps;
    }

    public void setEmvqrcps(String emvqrcps) {
        this.emvqrcps = emvqrcps;
    }

    public String getTransactionIdentification() {
        return transactionIdentification;
    }

    public void setTransactionIdentification(String transactionIdentification) {
        this.transactionIdentification = transactionIdentification;
    }
}
