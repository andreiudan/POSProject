package com.pos.proiectpos.common;

import java.util.List;



public class ProductDto {
    Long id;
    String quantity;
    String name;
    String price;

    public ProductDto(Long id, String licensePlate, String parkingSpot,String price) {
        this.id = id;
        this.quantity = quantity;
        this.name = name;
        this.price=price;
    }

    public Long getId() {
        return id;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }


}
