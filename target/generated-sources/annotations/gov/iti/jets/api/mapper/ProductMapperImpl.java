package gov.iti.jets.api.mapper;

import gov.iti.jets.dtos.CategoryDto;
import gov.iti.jets.dtos.ProductDto;
import gov.iti.jets.repo.entities.CategoryEntity;
import gov.iti.jets.repo.entities.ProductEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-07T22:30:02+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (Eclipse Adoptium)"
)
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDto productEntityToDto(ProductEntity productEntity) {
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

    @Override
    public ProductEntity productDtoToEntity(ProductDto productDto) {
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

    protected CategoryDto categoryEntityToCategoryDto(CategoryEntity categoryEntity) {
        if ( categoryEntity == null ) {
            return null;
        }

        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setCategoryId( categoryEntity.getCategoryId() );
        categoryDto.setCategoryName( categoryEntity.getCategoryName() );

        return categoryDto;
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
}
