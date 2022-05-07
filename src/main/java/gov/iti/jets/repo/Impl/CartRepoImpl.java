package gov.iti.jets.repo.Impl;

import java.util.List;
import gov.iti.jets.repo.CartRepo;
import gov.iti.jets.repo.entities.CartEntity;
import gov.iti.jets.repo.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;


public class CartRepoImpl implements CartRepo {
    private static CartRepoImpl cartRepoImpl;
    public  EntityManagerFactory entityManagerFactory = JpaUtil.getInstance().entityManagerFactory;


    private CartRepoImpl() {
    }

    public static CartRepoImpl getInstance() {
        if (cartRepoImpl == null) {
            cartRepoImpl = new CartRepoImpl();

        }
        return cartRepoImpl;
    }

    @Override
    public List<CartEntity> getUserCartByUserId(int userId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("" +
                "select  c from CartEntity c join c.customer u where  u.id=:user_id", CartEntity.class);
        query.setParameter("user_id",userId);
        List<CartEntity> cartEntityList = (List<CartEntity>) query.getResultList();
        System.out.println(cartEntityList);
        return cartEntityList;
    }



    @Override
    public CartEntity updateCart(CartEntity cartEntity, int userId) {
        EntityManager em =entityManagerFactory.createEntityManager();
        CartEntity updatedCart = getUserCartByUserId(userId).get(0);
        updatedCart.setProduct(cartEntity.getProduct());
        updatedCart.setQuantity(cartEntity.getQuantity());
        em.getTransaction().begin();
        CartEntity newCart=em.merge(updatedCart);
        em.getTransaction().commit();
        return newCart;

    }





}
