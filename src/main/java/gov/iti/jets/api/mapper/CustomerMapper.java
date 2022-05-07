package gov.iti.jets.api.mapper;

import gov.iti.jets.dtos.CustomerDto;
import gov.iti.jets.repo.entities.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper instance = Mappers.getMapper(CustomerMapper.class);
    CustomerDto customerEntityToDto(CustomerEntity customerEntity);
    CustomerEntity customerDtoToEntity(CustomerDto customerDto);
}



