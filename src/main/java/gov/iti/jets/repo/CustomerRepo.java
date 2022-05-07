package gov.iti.jets.repo;

import java.util.List;
import gov.iti.jets.repo.entities.CustomerEntity;

public interface CustomerRepo {

    CustomerEntity addCustomer(CustomerEntity user);

    CustomerEntity updateCustomer(CustomerEntity user);

    CustomerEntity findCustomerById(int id);

    boolean deleteCustomer(int id);

    List<CustomerEntity> getAllCustomers();

}
