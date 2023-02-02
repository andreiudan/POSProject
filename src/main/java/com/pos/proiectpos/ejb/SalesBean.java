package com.pos.proiectpos.ejb;

import com.pos.proiectpos.common.SalesDto;
import com.pos.proiectpos.entities.Product;
import com.pos.proiectpos.entities.Sales;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Stateless
public class SalesBean {
    private static final Logger LOG = Logger.getLogger(ProductsBean.class.getName());

    @PersistenceContext
    EntityManager entityManager;

    public void createSale(Long productId) {
        LOG.info("createSale");

        Sales sale = new Sales();
        sale.setProductId(productId);
        sale.setQuantity(1);

        entityManager.persist(sale);
    }

    public List<SalesDto> findAllSales() {
        LOG.info("findAllSales");

        try {
            TypedQuery<Sales> typedQuery = entityManager.createQuery("SELECT c FROM Sales c", Sales.class);
            List<Sales> sales = typedQuery.getResultList();

            return copySalesToDto(sales);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public List<Long> findAllSalesIds(){
        List<Long> ids=
                entityManager.createQuery("Select s.productId FROM Sales s", Long.class)
                        .getResultList();

        return ids;
    }

    public List<SalesDto> copySalesToDto(List<Sales> sales){
        LOG.info("copySalesToDto");

        List<SalesDto> salesDto;
        salesDto = sales.
                stream().
                map(x -> new SalesDto(x.getId(), x.getProductId(), x.getQuantity())).collect(Collectors.toList());

        return salesDto;
    }

    public void deleteSale(Long productId) {
        LOG.info("deleteSale");

        try {
            Sales sale = entityManager.createQuery("SELECT s FROM Sales s WHERE s.productId = :productId ", Sales.class)
                    .setParameter("productId", productId)
                    .getSingleResult();

            if (sale != null) {
                entityManager.remove(sale);
            }
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public boolean checkIfSaleExists(Long productId){
        LOG.info("checkIfSaleExists");

        try {
            Sales sale = null;

            TypedQuery<Sales> typedQuery = entityManager.createQuery("SELECT s FROM Sales s WHERE s.productId = :productId ", Sales.class)
                    .setParameter("productId", productId);
            if(!(typedQuery.getResultList().isEmpty())){
                sale = typedQuery.getSingleResult();
            }

            if (sale != null) {
                return true;
            }
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
        return false;
    }

    public void updateSale(Long salesId, int quantity) {
        LOG.info("updateSale");
        Sales sale=entityManager.find(Sales.class,salesId);
        sale.setQuantity(quantity);
    }

    public SalesDto findById(Long saleId) {
        LOG.info("findById");

        Sales sale = entityManager.find(Sales.class, saleId);

        return new SalesDto(sale.getId(), sale.getProductId(), sale.getQuantity());
    }

}
