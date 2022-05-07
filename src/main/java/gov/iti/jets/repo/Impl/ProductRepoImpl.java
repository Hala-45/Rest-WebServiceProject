package gov.iti.jets.repo.Impl;

import gov.iti.jets.repo.ProductRepo;
import gov.iti.jets.repo.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;
import gov.iti.jets.repo.entities.ProductEntity;

public class ProductRepoImpl implements ProductRepo {

    private static ProductRepoImpl productRepoImpl;
    public  EntityManagerFactory entityManagerFactory = JpaUtil.getInstance().entityManagerFactory;
    private ProductRepoImpl() {
    }

    public static ProductRepoImpl getInstance() {
        if (productRepoImpl == null) {
            productRepoImpl = new ProductRepoImpl();

        }
        return productRepoImpl;
    }

    @Override
    public List<ProductEntity> getAllProductByCategoryId(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<ProductEntity> query = entityManager.createNamedQuery("select p from ProductEntity p where p.category.categoryId like :category_id", ProductEntity.class);
        query.setParameter("category_id", id);
        return query.getResultList();
    }

    @Override
    public List<ProductEntity> getProductByName(String productName) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<ProductEntity> query = entityManager.createQuery("select p from ProductEntity p   where  p.name  LIKE : product_name", ProductEntity.class);
        query.setParameter("product_name","%"+ productName+"%");
        return query.getResultList();
    }


    @Override
    public List<ProductEntity> getAllProducts() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<ProductEntity> resultList = (List<ProductEntity>) entityManager.createQuery("SELECT p FROM ProductEntity p").getResultList();
        return resultList;
    }

    @Override
    public ProductEntity saveProduct(ProductEntity product) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(product);
        entityManager.getTransaction().commit();
        return product;
    }

    @Override
    public ProductEntity updateProduct(ProductEntity product) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        long id = product.getId();
        ProductEntity updatedProduct =  getProductById(id);
        updatedProduct.setDescription(product.getDescription());
        updatedProduct.setPrice(product.getPrice());
        updatedProduct.setQuantity(product.getQuantity());
        updatedProduct.setName(product.getName());

        entityManager.getTransaction().begin();
        entityManager.merge(updatedProduct);
        entityManager.getTransaction().commit();
        return updatedProduct;
    }

    @Override
    public ProductEntity getProductById(long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<ProductEntity> query = entityManager.createQuery("select p from ProductEntity p where  p.id = :id", ProductEntity.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public boolean deleteProduct(long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
       Query query = entityManager.createQuery("DELETE FROM ProductEntity p WHERE p.id like :id").setParameter("id",id);
       if(query.executeUpdate()==1){
           entityManager.getTransaction().commit();;
           return true;
       }
       return false;
    }

}
