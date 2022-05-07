package gov.iti.jets.repo;

import java.util.List;
import gov.iti.jets.repo.entities.ProductEntity;

public interface ProductRepo {

    List<ProductEntity> getAllProductByCategoryId(int id);

    List<ProductEntity> getProductByName(String productName);


    List<ProductEntity> getAllProducts();

    ProductEntity saveProduct(ProductEntity product);

    ProductEntity updateProduct(ProductEntity product);

   ProductEntity getProductById(long id);

    boolean deleteProduct(long id);


}
