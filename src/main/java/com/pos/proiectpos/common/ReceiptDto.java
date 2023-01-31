package com.pos.proiectpos.common;

public class ReceiptDto {
    private Long id;

    private Long cashierId;

    private String date;

    public ReceiptDto(Long id, Long cashierId, String date) {
        this.id = id;
        this.cashierId = cashierId;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public Long getCashierId() {
        return cashierId;
    }

    public String getDate() {
        return date;
    }
}
