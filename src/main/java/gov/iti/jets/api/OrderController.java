package gov.iti.jets.api;

import gov.iti.jets.api.mapper.CustomerMapper;
import gov.iti.jets.dtos.CustomerDto;
import gov.iti.jets.dtos.OrderDto;
import gov.iti.jets.repo.entities.OrderEntity;
import gov.iti.jets.repo.Impl.OrderRepoImpl;
import gov.iti.jets.repo.OrderRepo;
import gov.iti.jets.api.mapper.OrderMapper;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Path("orders")
public class OrderController {

    OrderRepo orderRepo = OrderRepoImpl.getInstance();

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllOrderProductsByUserId(@PathParam("id") int id) {
        List<OrderDto> orderList = orderRepo.getAllOrderProductsByUserId(id).stream().map(
                orderEntity ->{
                    OrderDto orderDto = OrderMapper.instance.orderEntityToDto(orderEntity);
                    return orderDto;
                }
        ).collect(Collectors.toList());
        GenericEntity entity = new GenericEntity<List<OrderDto>>(orderList){};
        return Response.ok(entity).build();

    }

    @DELETE
    @Path("{id}")
    public boolean deleteOrder(@PathParam("id") int id) {
        boolean deleted = orderRepo.deleteOrderByUserId(id);
        return deleted;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public OrderDto addOrder(OrderDto orderDto) {
        OrderDto addedOrder = OrderMapper.instance.orderEntityToDto(
                orderRepo.addOrder(OrderMapper.instance.orderDtoToEntity(orderDto)));
        return addedOrder;
    }

}