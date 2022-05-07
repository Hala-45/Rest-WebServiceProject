package gov.iti.jets.repo.Impl;

import gov.iti.jets.repo.AdminRepo;
import gov.iti.jets.repo.entities.AdminEntity;
import gov.iti.jets.repo.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class AdminRepoImpl implements AdminRepo {
    private static AdminRepoImpl adminRepoImpl;
    public  EntityManagerFactory entityManagerFactory = JpaUtil.getInstance().entityManagerFactory;
    private AdminRepoImpl() {
    }

    public static AdminRepoImpl getInstance() {
        if (adminRepoImpl == null) {
            adminRepoImpl = new AdminRepoImpl();

        }
        return adminRepoImpl;
    }



        
    public List<AdminEntity> getAllAdmins() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("select u from AdminEntity u ", AdminEntity.class);
        List<AdminEntity> adminEntityList = (List<AdminEntity>) query.getResultList();
        return adminEntityList;
    }

}
