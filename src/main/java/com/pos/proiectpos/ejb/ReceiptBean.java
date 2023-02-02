package com.pos.proiectpos.ejb;

import com.pos.proiectpos.common.SalesDto;
import com.pos.proiectpos.entities.Receipt;
import com.pos.proiectpos.entities.Sales;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class ReceiptBean {

    private static final Logger LOG = Logger.getLogger(ReceiptBean.class.getName());

    @PersistenceContext
    EntityManager entityManager;

    public void createReceipt(Long cashierId, Collection<SalesDto> soldProducts){
        LOG.info("createReceipt");

        /*List<Sales> sales = new ArrayList();
        for(SalesDto sale : soldProducts){
            Sales s = new Sales();
            s.setProductId(sale.getProductId());
            s.setQuantity(sale.getQuantity());
            sales.add(s);
        }*/

        Receipt receipt = new Receipt();
        receipt.setCashierId(cashierId);
        receipt.setDate(new Date());
        //receipt.setSoldProducts(sales);

        entityManager.persist(receipt);
    }

}
