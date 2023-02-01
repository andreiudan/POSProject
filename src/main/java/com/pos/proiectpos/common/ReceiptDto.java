package com.pos.proiectpos.common;

import com.pos.proiectpos.entities.Sales;

import java.util.List;

public class ReceiptDto {
    private Long id;

    private Long cashierId;

    private String date;

    private List<SalesDto> sales;

    public ReceiptDto(Long id, Long cashierId, String date, List<SalesDto> sales) {
        this.id = id;
        this.cashierId = cashierId;
        this.date = date;
        this.sales = sales;
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

    public List<SalesDto> getSales() {
        return sales;
    }
}
