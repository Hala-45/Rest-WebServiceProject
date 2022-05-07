package gov.iti.jets.api.mapper;

import gov.iti.jets.dtos.CartDto;
import gov.iti.jets.dtos.CategoryDto;
import gov.iti.jets.dtos.ProductDto;
import gov.iti.jets.repo.entities.CartEntity;
import gov.iti.jets.repo.entities.CategoryEntity;
import gov.iti.jets.repo.entities.ProductEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-07T22:30:01+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (Eclipse Adoptium)"
)
public class CartMapperImpl implements CartMapper {

    @Override
    public CartDto cartEntityToDto(CartEntity cartEntity) {
        if ( cartEntity == null ) {
            return null;
        }

        CartDto cartDto = new CartDto();

        cartDto.setProduct( productEntityToProductDto( cartEntity.getProduct() ) );
        cartDto.setQuantity( cartEntity.getQuantity() );

        return cartDto;
    }

    @Override
    public CartEntity cartDtoToEntity(CartDto cart) {
        if ( cart == null ) {
            return null;
        }

        CartEntity cartEntity = new CartEntity();

        cartEntity.setQuantity( cart.getQuantity() );
        cartEntity.setProduct( productDtoToProductEntity( cart.getProduct() ) );

        return cartEntity;
    }

    protected CategoryDto categoryEntityToCategoryDto(CategoryEntity categoryEntity) {
        if ( categoryEntity == null ) {
            return null;
        }

        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setCategoryId( categoryEntity.getCategoryId() );
        categoryDto.setCategoryName( categoryEntity.getCategoryName() );

        return categoryDto;
    }

    protected ProductDto productEntityToProductDto(ProductEntity productEntity) {
        if ( productEntity == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setId( productEntity.getId() );
        productDto.setName( productEntity.getName() );
        productDto.setPrice( productEntity.getPrice() );
        productDto.setQuantity( productEntity.getQuantity() );
        productDto.setDescription( productEntity.getDescription() );
        productDto.setCategory( categoryEntityToCategoryDto( productEntity.getCategory() ) );

        return productDto;
    }

    protected CategoryEntity categoryDtoToCategoryEntity(CategoryDto categoryDto) {
        if ( categoryDto == null ) {
            return null;
        }

        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setCategoryId( categoryDto.getCategoryId() );
        categoryEntity.setCategoryName( categoryDto.getCategoryName() );

        return categoryEntity;
    }

    protected ProductEntity productDtoToProductEntity(ProductDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        ProductEntity productEntity = new ProductEntity();

        productEntity.setId( productDto.getId() );
        productEntity.setName( productDto.getName() );
        productEntity.setPrice( productDto.getPrice() );
        productEntity.setQuantity( productDto.getQuantity() );
        productEntity.setDescription( productDto.getDescription() );
        productEntity.setCategory( categoryDtoToCategoryEntity( productDto.getCategory() ) );

        return productEntity;
    }
}
