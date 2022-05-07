 package gov.iti.jets.api.mapper;


 import gov.iti.jets.dtos.OrderDto;
 import gov.iti.jets.repo.entities.OrderEntity;
 import org.mapstruct.Mapper;
 import org.mapstruct.factory.Mappers;

 @Mapper
 public interface OrderMapper {
     OrderMapper instance = Mappers.getMapper(OrderMapper.class);
     OrderDto orderEntityToDto(OrderEntity orderEntity);
     OrderEntity orderDtoToEntity(OrderDto OrderDto);
 }



