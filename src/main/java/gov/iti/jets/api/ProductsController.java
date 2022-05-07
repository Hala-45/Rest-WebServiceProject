package gov.iti.jets.api;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import gov.iti.jets.dtos.ProductDto;
import gov.iti.jets.repo.entities.ProductEntity;
import gov.iti.jets.repo.Impl.ProductRepoImpl;
import gov.iti.jets.repo.ProductRepo;
import gov.iti.jets.api.mapper.ProductMapper;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("products")
public class ProductsController {

  ProductRepo productRepo = ProductRepoImpl.getInstance();

    @GET
	@Produces(MediaType.APPLICATION_JSON)
    public Response getAllProducts() {


                 List<ProductDto> productList = productRepo.getAllProducts().stream().map(
                        productEntity ->{
                            ProductDto productDto = ProductMapper.instance.productEntityToDto(productEntity);
                            return productDto;
                        }
                ).collect(Collectors.toList());
                 GenericEntity entity = new GenericEntity<List<ProductDto>>(productList){};
                 return Response.ok(entity).build();

    }



    @GET
    @Path("{id}")
    public Response getProductById(@PathParam("id") long id) {
         ProductDto productDto = ProductMapper.instance.productEntityToDto(productRepo.getProductById(id));
         return Response.ok(productDto).build();

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public ProductDto addProduct(ProductDto product) {
        ProductDto addedProduct = ProductMapper.instance.productEntityToDto(
                productRepo.saveProduct(ProductMapper.instance.productDtoToEntity(product)));
        return addedProduct;
    }


    @GET
    @Path("categories/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public List<ProductDto> getAllProductsByCategoryId(@PathParam("id") int id) {
        List<ProductDto> productList = new ArrayList<>();
        for(ProductEntity productEntity : productRepo.getAllProductByCategoryId(id) ){
            productList.add(ProductMapper.instance.productEntityToDto(productEntity));
        }
        return productList;

    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("productName")
    public List <ProductDto> getProductByName(@QueryParam("name") String productName) {
        List<ProductDto> productList = new ArrayList<>();
        for(ProductEntity productEntity : productRepo.getProductByName(productName) ){
            productList.add(ProductMapper.instance.productEntityToDto(productEntity));
        }
       return productList;


   }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public ProductDto editProduct(ProductDto product) {
        ProductDto updatedProduct = ProductMapper.instance.productEntityToDto(
                productRepo.updateProduct( ProductMapper.instance.productDtoToEntity(product)));
        return updatedProduct;
    }
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean deleteProduct(@PathParam("id") long id){
        boolean deleted = productRepo.deleteProduct(id);
        return deleted;
    }
}