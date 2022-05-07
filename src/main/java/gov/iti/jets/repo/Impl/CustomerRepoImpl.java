package gov.iti.jets.repo.Impl;

import gov.iti.jets.repo.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.List;
import gov.iti.jets.repo.CustomerRepo;
import gov.iti.jets.repo.entities.CustomerEntity;
import jakarta.persistence.Query;

public class CustomerRepoImpl implements CustomerRepo {
    public  EntityManagerFactory entityManagerFactory = JpaUtil.getInstance().entityManagerFactory;


    private static CustomerRepoImpl customerRepoImpl;

    private CustomerRepoImpl() {
    }

    public static CustomerRepoImpl getInstance() {
        if (customerRepoImpl == null) {
            customerRepoImpl = new CustomerRepoImpl();

        }
        return customerRepoImpl;
    }

    @Override
    public CustomerEntity findCustomerById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<CustomerEntity> query = entityManager.createQuery("SELECT c FROM CustomerEntity c where  c.id = :id",
                CustomerEntity.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public CustomerEntity addCustomer(CustomerEntity user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        return user;
    }


    @Override
    public CustomerEntity updateCustomer(CustomerEntity user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        int id = user.getId();
        CustomerEntity updatedUser = findCustomerById(id);
        updatedUser.setUserName(user.getUserName());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setPass(user.getPass());
        entityManager.getTransaction().begin();
        entityManager.merge(updatedUser);
        entityManager.getTransaction().commit();
        return updatedUser;

    }

    @Override
    public boolean deleteCustomer(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("DELETE FROM CustomerEntity c WHERE c.id like :id");
        query.setParameter("id", id);
        if (query.executeUpdate() == 1) {
            entityManager.getTransaction().commit();
            return true;
        } else {
            return false;
        }

    }

    @Override
    public List<CustomerEntity> getAllCustomers() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<CustomerEntity> resultList = (List<CustomerEntity>) entityManager
                .createQuery("SELECT c FROM CustomerEntity c ").getResultList();
        return resultList;
    }



}
