package com.pos.proiectpos.common;

public class ReceiptDto {
    private Long id;

    private Long productId;

    private int quantity;

    public ReceiptDto(Long id, Long productId, int quantity) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public Long getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }
}
