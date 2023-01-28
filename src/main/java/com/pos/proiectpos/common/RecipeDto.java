package com.pos.proiectpos.common;

public class RecipeDto {
    private Long id;

    private Long productId;

    private int quantity;

    public RecipeDto(Long id, Long productId, int quantity) {
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
