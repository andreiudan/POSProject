package com.pos.proiectpos.ejb;

import com.pos.proiectpos.common.ProductDto;
import com.pos.proiectpos.common.ProductPhotoDto;
import com.pos.proiectpos.entities.Product;
import com.pos.proiectpos.entities.ProductPhoto;
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
public class ProductsBean {

    private static final Logger LOG = Logger.getLogger(ProductsBean.class.getName());

    @PersistenceContext
    EntityManager entityManager;

    public void createProduct(String name,int quantity, float price, String barcode, String description, String category) {
        LOG.info("createProduct");

        Product product= new Product();
        product.name = name;
        product.quantity = quantity;
        product.price = price;
        product.barcode = barcode;
        product.description = description;
        product.category = category;

        entityManager.persist(product);
    }

    public List<ProductDto> copyProductsToDto(List<Product> products){
        LOG.info("copyProductsToDto");

        List<ProductDto> productDto;
        productDto = products.
                stream().
                map(x -> new ProductDto(x.getId(), x.getQuantity(), x.getName(), x.getPrice(), x.getBarcode(), x.getDescription(), x.getCategory())).collect(Collectors.toList());

        return productDto;
    }

    public List<ProductDto> findAllProducts() {
        LOG.info("findAllProducts");

        try {
            TypedQuery<Product> typedQuery = entityManager.createQuery("SELECT c FROM Product c", Product.class);
            List<Product> products = typedQuery.getResultList();

            return copyProductsToDto(products);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    public ProductDto findById(Long productId)
    {
        LOG.info("findById");

        Product product=entityManager.find(Product.class,productId);

        return new ProductDto(product.getId(),product.getQuantity(),product.getName(),product.getPrice(),product.getBarcode(),product.getDescription(),product.getCategory());
    }

    public void updateProduct(Long productId,String name,int quantity,float price,String barcode,String description,String category) {
        LOG.info("updateProduct");

        Product product=entityManager.find(Product.class,productId);
        product.setName(name);
        product.setQuantity(quantity);
        product.setPrice(price);
        product.setBarcode(barcode);
        product.setDescription(description);
        product.setCategory(category);
    }

    public void deleteProductsByIds(Collection<Long> productIds) {
        LOG.info("deleteProductsByIds");

        for(Long productId:productIds)
        {
            Product product=entityManager.find(Product.class,productId);
            entityManager.remove(product);
        }
    }


    public void addPhotoToProduct(Long productId, String filename, String fileType, byte[] fileContent) {
        LOG.info("addPhotoToProduct");

        ProductPhoto photo = new ProductPhoto();
        photo.setFilename(filename);
        photo.setFileType(fileType);
        photo.setFileContent(fileContent);
        Product product = entityManager.find(Product.class, productId);

        if (product.getPhoto() != null) {
            entityManager.remove(product.getPhoto());
        }

        product.setPhoto(photo);
        photo.setProduct(product);
        entityManager.persist(photo);
    }

    public ProductPhotoDto findPhotoByProductId(Integer productId) {
        LOG.info("findPhotoByProductId");

        List<ProductPhoto> photos = entityManager
                .createQuery("SELECT p FROM ProductPhoto p where p.product.id = :id", ProductPhoto.class)
                .setParameter("id", productId)
                .getResultList();

        if (photos.isEmpty()) {
            return null;
        }

        ProductPhoto photo = photos.get(0);
        return new ProductPhotoDto(photo.getId(), photo.getFilename(), photo.getFileType(), photo.getFileContent());
    }

    public List<ProductDto> findProductsByIds(Collection<Long> productsIds){
        LOG.info("findProductsByIds");

        List<Product> products=
                entityManager.createQuery("Select p FROM Product p WHERE p.id IN :productsIds",Product.class)
                        .setParameter("productsIds",productsIds)
                        .getResultList();

        return copyProductsToDto(products);
    }

}
