package gov.iti.jets.api.mapper;

import gov.iti.jets.dtos.AdminDto;
import gov.iti.jets.repo.entities.AdminEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-07T22:30:02+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (Eclipse Adoptium)"
)
public class AdminMapperImpl implements AdminMapper {

    @Override
    public AdminDto adminEntityToDto(AdminEntity adminEntity) {
        if ( adminEntity == null ) {
            return null;
        }

        AdminDto adminDto = new AdminDto();

        adminDto.setId( adminEntity.getId() );
        adminDto.setName( adminEntity.getName() );
        adminDto.setEmail( adminEntity.getEmail() );

        return adminDto;
    }

    @Override
    public AdminEntity adminDtoToEntity(AdminDto admin) {
        if ( admin == null ) {
            return null;
        }

        AdminEntity adminEntity = new AdminEntity();

        adminEntity.setId( admin.getId() );
        adminEntity.setName( admin.getName() );
        adminEntity.setEmail( admin.getEmail() );

        return adminEntity;
    }
}
