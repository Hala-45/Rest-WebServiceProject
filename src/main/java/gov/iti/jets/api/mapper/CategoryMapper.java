package gov.iti.jets.api.mapper;

import gov.iti.jets.dtos.CategoryDto;
import gov.iti.jets.repo.entities.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {
    CategoryMapper instance = Mappers.getMapper(CategoryMapper.class);
    CategoryDto categoryEntityToDto(CategoryEntity categoryEntity);
    CategoryEntity categoryDtoToEntity(CategoryDto categoryDto);
}


