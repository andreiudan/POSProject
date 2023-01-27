package com.pos.proiectpos.common;

import java.util.List;



public class ProductDto {
    Long id;
    int quantity;
    String name;
    float price;

    public ProductDto(Long id, int quantity, String name, float price) {
        this.id = id;
        this.quantity = quantity;
        this.name = name;
        this.price=price;
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


}
