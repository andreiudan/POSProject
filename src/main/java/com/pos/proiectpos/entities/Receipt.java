package com.pos.proiectpos.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.Collection;

@Entity
public class Receipt {
    private Long id;

    private Long cashierId;

    String date;

    private Collection<Sales> soldProducts;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCashierId() {
        return cashierId;
    }

    public void setCashierId(Long cashierId) {
        this.cashierId = cashierId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @OneToMany
    public Collection<Sales> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(Collection<Sales> soldProducts) {
        this.soldProducts = soldProducts;
    }
}
