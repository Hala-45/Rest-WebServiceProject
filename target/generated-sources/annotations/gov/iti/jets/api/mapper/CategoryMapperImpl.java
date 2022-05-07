package gov.iti.jets.api.mapper;

import gov.iti.jets.dtos.CategoryDto;
import gov.iti.jets.repo.entities.CategoryEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-07T22:30:02+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (Eclipse Adoptium)"
)
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryDto categoryEntityToDto(CategoryEntity categoryEntity) {
        if ( categoryEntity == null ) {
            return null;
        }

        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setCategoryId( categoryEntity.getCategoryId() );
        categoryDto.setCategoryName( categoryEntity.getCategoryName() );

        return categoryDto;
    }

    @Override
    public CategoryEntity categoryDtoToEntity(CategoryDto categoryDto) {
        if ( categoryDto == null ) {
            return null;
        }

        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setCategoryId( categoryDto.getCategoryId() );
        categoryEntity.setCategoryName( categoryDto.getCategoryName() );

        return categoryEntity;
    }
}
