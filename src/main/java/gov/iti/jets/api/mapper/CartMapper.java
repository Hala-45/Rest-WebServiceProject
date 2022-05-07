package gov.iti.jets.api.mapper;

import gov.iti.jets.dtos.CartDto;
import gov.iti.jets.repo.entities.CartEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CartMapper {
    CartMapper instance = Mappers.getMapper(CartMapper.class);
    CartDto cartEntityToDto(CartEntity cartEntity);
    CartEntity cartDtoToEntity(CartDto cart);
}
