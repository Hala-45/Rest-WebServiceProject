package gov.iti.jets.api.mapper;

import gov.iti.jets.dtos.OrderDto;
import gov.iti.jets.repo.entities.OrderEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-07T22:30:01+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (Eclipse Adoptium)"
)
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderDto orderEntityToDto(OrderEntity orderEntity) {
        if ( orderEntity == null ) {
            return null;
        }

        OrderDto orderDto = new OrderDto();

        orderDto.setDescription( orderEntity.getDescription() );
        orderDto.setPhoneNumber( orderEntity.getPhoneNumber() );
        orderDto.setTotalPrice( orderEntity.getTotalPrice() );
        orderDto.setEmail( orderEntity.getEmail() );

        return orderDto;
    }

    @Override
    public OrderEntity orderDtoToEntity(OrderDto OrderDto) {
        if ( OrderDto == null ) {
            return null;
        }

        OrderEntity orderEntity = new OrderEntity();

        orderEntity.setDescription( OrderDto.getDescription() );
        orderEntity.setTotalPrice( OrderDto.getTotalPrice() );
        orderEntity.setPhoneNumber( OrderDto.getPhoneNumber() );
        orderEntity.setEmail( OrderDto.getEmail() );

        return orderEntity;
    }
}
