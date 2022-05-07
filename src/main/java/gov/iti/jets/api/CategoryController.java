package gov.iti.jets.api;

import java.util.List;
import java.util.stream.Collectors;

import gov.iti.jets.dtos.CategoryDto;
import gov.iti.jets.dtos.ProductDto;
import gov.iti.jets.repo.CategoryRepo;
import gov.iti.jets.repo.Impl.CategoryRepoImpl;
import gov.iti.jets.api.mapper.CategoryMapper;
import gov.iti.jets.api.mapper.ProductMapper;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("categories")
public class CategoryController {

    CategoryRepo categoryRepo = CategoryRepoImpl.getInstance();

    @GET
    public Response getAllCategories() {
                 List<CategoryDto> categoryList = categoryRepo.getAllCategories().stream().map(
                categoryEntity ->{
                    CategoryDto categoryDto = CategoryMapper.instance.categoryEntityToDto(categoryEntity);
                    return categoryDto;
                }
        ).collect(Collectors.toList());
         GenericEntity entity = new GenericEntity<List<CategoryDto>>(categoryList){};
         return Response.ok(entity).build();


    }


    @GET
    @Path("{id}")
    public Response getCategoryById(@PathParam("id") int id) {

        CategoryDto categoryDto = CategoryMapper.instance.categoryEntityToDto(categoryRepo.getCategoryById(id));
         return Response.ok(categoryDto).build();

    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public CategoryDto updateCategory(CategoryDto categoryDto){
        CategoryDto updatedCategory = CategoryMapper.instance.categoryEntityToDto(
                categoryRepo.updateCategory(CategoryMapper.instance.categoryDtoToEntity(categoryDto)));
        return updatedCategory;
    }

    @DELETE
    @Path("{id}")
    public boolean deleteCategory(@PathParam("id") int id){
        boolean deleted = categoryRepo.deleteCategory(id);
        return deleted;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public CategoryDto addCategory(CategoryDto categoryDto){
        CategoryDto addedCategory = CategoryMapper.instance.categoryEntityToDto(
                categoryRepo.addCategory(CategoryMapper.instance.categoryDtoToEntity(categoryDto)));
        return addedCategory;
    }

    @GET
    @Path("products/{id}")
    public Response getAllProductsForCategory(@PathParam("id") int id){
        List<ProductDto> productList = categoryRepo.getAllProductsByCatgeoryId(id).stream().map(
                productEntity ->{
                    ProductDto productDto = ProductMapper.instance.productEntityToDto(productEntity);
                    return productDto;
                }
        ).collect(Collectors.toList());
        GenericEntity entity = new GenericEntity<List<ProductDto>>(productList){};
        return Response.ok(entity).build();
    }


}