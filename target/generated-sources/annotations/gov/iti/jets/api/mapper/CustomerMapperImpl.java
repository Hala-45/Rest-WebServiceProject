package gov.iti.jets.api.mapper;

import gov.iti.jets.dtos.CustomerDto;
import gov.iti.jets.repo.entities.CustomerEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-07T22:30:01+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (Eclipse Adoptium)"
)
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerDto customerEntityToDto(CustomerEntity customerEntity) {
        if ( customerEntity == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        customerDto.setId( customerEntity.getId() );
        customerDto.setUserName( customerEntity.getUserName() );
        customerDto.setEmail( customerEntity.getEmail() );
        customerDto.setPass( customerEntity.getPass() );

        return customerDto;
    }

    @Override
    public CustomerEntity customerDtoToEntity(CustomerDto customerDto) {
        if ( customerDto == null ) {
            return null;
        }

        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setId( customerDto.getId() );
        customerEntity.setUserName( customerDto.getUserName() );
        customerEntity.setEmail( customerDto.getEmail() );
        customerEntity.setPass( customerDto.getPass() );

        return customerEntity;
    }
}
