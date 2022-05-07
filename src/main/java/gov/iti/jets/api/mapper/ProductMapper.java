package gov.iti.jets.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import gov.iti.jets.dtos.ProductDto;
import gov.iti.jets.repo.entities.ProductEntity;

@Mapper
public interface ProductMapper {
    ProductMapper instance = Mappers.getMapper(ProductMapper.class);
    ProductDto productEntityToDto(ProductEntity productEntity);
    ProductEntity productDtoToEntity(ProductDto productDto);
}



