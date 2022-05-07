package gov.iti.jets.api;

import gov.iti.jets.dtos.AdminDto;
import gov.iti.jets.repo.AdminRepo;
import gov.iti.jets.repo.Impl.AdminRepoImpl;
import gov.iti.jets.api.mapper.AdminMapper;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.stream.Collectors;


@Path("admins")
public class AdminController {
    AdminRepo adminRepo = AdminRepoImpl.getInstance();
    @GET
    public Response getAllCustomers(){

        List<AdminDto> adminList = adminRepo.getAllAdmins().stream().map(
                adminEntity ->{
                    AdminDto customerDto = AdminMapper.instance.adminEntityToDto(adminEntity);
                    return customerDto;
                }
        ).collect(Collectors.toList());



        GenericEntity entity = new GenericEntity<List<AdminDto>>(adminList){};
        return Response.ok(entity).build();
    }


}