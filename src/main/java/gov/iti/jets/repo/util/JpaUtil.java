package gov.iti.jets.repo.util;

import jakarta.persistence.EntityManagerFactory;

public class JpaUtil {
    private static JpaUtil persistence;
    public  EntityManagerFactory entityManagerFactory;


    private JpaUtil() {
        this.entityManagerFactory = jakarta.persistence.Persistence.createEntityManagerFactory("rest");
    }

    public static JpaUtil getInstance() {
        if (persistence == null) {
            persistence = new JpaUtil();

        }
        return persistence;
    }
}
