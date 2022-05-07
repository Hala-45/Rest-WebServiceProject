package gov.iti.jets.repo;

import java.util.List;

import gov.iti.jets.repo.entities.CategoryEntity;
import gov.iti.jets.repo.entities.ProductEntity;

public interface CategoryRepo {

    CategoryEntity addCategory(CategoryEntity category);

    boolean deleteCategory(int id);

    CategoryEntity getCategoryById(int id);

    List<CategoryEntity> getAllCategories();

    CategoryEntity updateCategory(CategoryEntity entity);

    List<ProductEntity>getAllProductsByCatgeoryId(int id);

}
