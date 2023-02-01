package com.pos.proiectpos.entities;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;

import java.util.Collection;
import java.util.Date;

import static jakarta.persistence.CascadeType.ALL;

@Entity
public class Receipt {
    @Id
    @GeneratedValue
    private Long id;

    private Long cashierId;

    Date date;

    @JsonbTransient
    @OneToMany(cascade = ALL,mappedBy = "receipt")
    private Collection<Sales> soldProducts;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public Collection<Sales> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(Collection<Sales> soldProducts) {
        this.soldProducts = soldProducts;
    }
}
