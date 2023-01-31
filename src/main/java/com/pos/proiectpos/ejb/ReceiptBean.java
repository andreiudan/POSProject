package com.pos.proiectpos.ejb;

import com.pos.proiectpos.entities.Receipt;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.logging.Logger;

@Stateless
public class ReceiptBean {

    private static final Logger LOG = Logger.getLogger(ReceiptBean.class.getName());

    @PersistenceContext
    EntityManager entityManager;

    public void createReceipt(Long cashierId, String date) {
        LOG.info("createReceipt");

        Receipt receipt = new Receipt();
        receipt.setCashierId(cashierId);
        receipt.setDate(date);

        entityManager.persist(receipt);
    }

}
