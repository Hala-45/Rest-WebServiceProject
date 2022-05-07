package gov.iti.jets.api;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import gov.iti.jets.dtos.CustomerDto;
import gov.iti.jets.repo.CustomerRepo;
import gov.iti.jets.repo.entities.CustomerEntity;
import gov.iti.jets.repo.Impl.CustomerRepoImpl;
import gov.iti.jets.api.mapper.CustomerMapper;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("customers")
public class CustomerController {

    CustomerRepo customerRepo = CustomerRepoImpl.getInstance();

    @GET
    public Response getAllCustomer() {
                 List<CustomerDto> customerList = customerRepo.getAllCustomers().stream().map(
                customerEntity ->{
                    CustomerDto customerDto = CustomerMapper.instance.customerEntityToDto(customerEntity);
                    return customerDto;
                }
        ).collect(Collectors.toList());
         GenericEntity entity = new GenericEntity<List<CustomerDto>>(customerList){};
         return Response.ok(entity).build();


    }


    @GET
    @Path("{id}")
    public Response getCustomerById(@PathParam("id") int id) {
        CustomerDto customerDto = CustomerMapper.instance.customerEntityToDto(customerRepo.findCustomerById(id));
         return Response.ok(customerDto).build();

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public CustomerDto addCustomer (CustomerDto customerDto){
        CustomerDto addedCustomer = CustomerMapper.instance.customerEntityToDto(
                customerRepo.addCustomer(CustomerMapper.instance.customerDtoToEntity(customerDto)));
        return addedCustomer;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public CustomerDto updateCustomer(CustomerDto customerDto){
        CustomerDto updatedCustomer = CustomerMapper.instance.customerEntityToDto(
                customerRepo.updateCustomer(CustomerMapper.instance.customerDtoToEntity(customerDto)));
        return updatedCustomer;
    }


    @DELETE
    @Path("{id}")
    public boolean deleteCustomer(@PathParam("id") int id){
        boolean deleted = customerRepo.deleteCustomer(id);
        return deleted;
    }


}
