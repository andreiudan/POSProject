package com.pos.proiectpos.ejb;

import com.pos.proiectpos.entities.PayByCard;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.logging.Logger;

@Stateless
public class PayByCardBean {

    Logger LOG = Logger.getLogger(PayByCardBean.class.getName());

    @PersistenceContext
    EntityManager entityManager;

    public void createPayByCard(String cardNumber, String cardExpirationDate, Double total) {
        LOG.info("createPayByCard");

        PayByCard payByCard = new PayByCard();
        payByCard.setCardNumber(cardNumber);
        payByCard.setCardExpirationDate(cardExpirationDate);
        payByCard.setTotal(total);

        entityManager.persist(payByCard);
    }
}
