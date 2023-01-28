package com.pos.proiectpos.common;

import java.util.List;



public class ProductDto {
    Long id;

    int quantity;

    String name;

    float price;

    String barcode;

    String description;

    String category;

    public ProductDto(Long id, int quantity, String name, float price, String barcode, String description, String category) {
        this.id = id;
        this.quantity = quantity;
        this.name = name;
        this.price = price;
        this.barcode = barcode;
        this.description = description;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }
}
