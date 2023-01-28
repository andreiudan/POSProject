package com.pos.proiectpos.ejb;

import com.pos.proiectpos.common.ProductDto;
import com.pos.proiectpos.entities.Product;
import com.pos.proiectpos.entities.User;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Stateless
public class ProductBean {

    private static final Logger LOG = Logger.getLogger(ProductBean.class.getName());

    @PersistenceContext
    EntityManager entityManager;

    public void createProduct(String name,int quantity, float price, Long id) {
        LOG.info("createProduct");

        Product product= new Product();
        product.name = name;
        product.quantity = quantity;
        product.price = price;

        entityManager.persist(product);
    }

    public List<ProductDto> findAllProducts() {
        LOG.info("findAllCars");

        try {
            TypedQuery<Product> typedQuery = entityManager.createQuery("SELECT c FROM Product c", Product.class);
            List<Product> products = typedQuery.getResultList();
            return copyProductsToDto(products);
        } catch (Exception ex) {
            throw new EJBException(ex);

        }
    }

    public List<ProductDto> copyProductsToDto(List<Product> products){
        List<ProductDto> productDto;
        productDto = products.
                stream().
                map(x -> new ProductDto(x.getId(), x.getQuantity(), x.getName(), x.getPrice(), x.getBarcode(), x.getDescription(), x.getCategory())).collect(Collectors.toList());
        return productDto;
    }
}
