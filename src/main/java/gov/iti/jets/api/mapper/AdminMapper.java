package gov.iti.jets.api.mapper;

import gov.iti.jets.dtos.AdminDto;
import gov.iti.jets.repo.entities.AdminEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdminMapper {
    AdminMapper instance = Mappers.getMapper(AdminMapper.class);
    AdminDto adminEntityToDto(AdminEntity adminEntity);
    AdminEntity adminDtoToEntity(AdminDto admin);
}

