package gov.iti.jets.api;

import gov.iti.jets.dtos.CartDto;
import gov.iti.jets.repo.CartRepo;
import gov.iti.jets.repo.entities.CartEntity;
import gov.iti.jets.repo.Impl.CartRepoImpl;
import gov.iti.jets.api.mapper.CartMapper;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Path("carts")
public class CartController {
    CartRepo cartRepo = CartRepoImpl.getInstance();

    @GET
    @Path("{id}")
    public Response getUserCarts(@PathParam("id") int id) {

   List<CartDto> customerList = cartRepo.getUserCartByUserId(id).stream().map(
                cartEntity ->{
                    CartDto customerDto = CartMapper.instance.cartEntityToDto(cartEntity);
                    return customerDto;
                }
        ).collect(Collectors.toList());
         GenericEntity entity = new GenericEntity<List<CartDto>>(customerList){};
         return Response.ok(entity).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public CartDto updateCart(CartDto cartDto,@PathParam("id") int id){
        CartDto updatedCart = CartMapper.instance.cartEntityToDto(
                cartRepo.updateCart(CartMapper.instance.cartDtoToEntity(cartDto),id));
        return updatedCart;
    }



    
}
