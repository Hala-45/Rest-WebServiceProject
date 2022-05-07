package gov.iti.jets.repo.Impl;

import gov.iti.jets.repo.util.JpaUtil;
import jakarta.jms.Session;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import gov.iti.jets.repo.OrderRepo;
import gov.iti.jets.repo.entities.OrderEntity;
import jakarta.transaction.Transaction;

import java.util.List;

public class OrderRepoImpl implements OrderRepo {

    private static OrderRepoImpl OrderRepoImpl;
    public  EntityManagerFactory entityManagerFactory = JpaUtil.getInstance().entityManagerFactory;
    private OrderRepoImpl() {
    }

    public static OrderRepoImpl getInstance() {
        if (OrderRepoImpl == null) {
            OrderRepoImpl = new OrderRepoImpl();

        }
        return OrderRepoImpl;
    }


    @Override
    public List<OrderEntity> getAllOrderProductsByUserId(int userId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<OrderEntity> query = entityManager.createQuery("select  o from OrderEntity o join o.orderDetails od where  od.user.id=:user_id", OrderEntity.class);
        query.setParameter("user_id", userId);
        return query.getResultList();
    }



    @Override
    public OrderEntity findOrderById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<OrderEntity> query = entityManager.createQuery("select  o from OrderEntity o join o.orderDetails od where  od.user.id=:id",
                OrderEntity.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public OrderEntity updateOrder(OrderEntity order) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        int id = order.getId();
        OrderEntity updateOrder = findOrderById(id);
        updateOrder.setDescription(order.getDescription());
        updateOrder.setEmail(order.getEmail());
        updateOrder.setPhoneNumber(order.getPhoneNumber());
        updateOrder.setTotalPrice(order.getTotalPrice());
        updateOrder.setOrderDetails(order.getOrderDetails());
        if (Session.SESSION_TRANSACTED==0){
            entityManager.getTransaction().begin();
        }
        OrderEntity userUpdated = entityManager.merge(updateOrder);
        entityManager.getTransaction().commit();

        return userUpdated;

    }

    @Override
    public boolean deleteOrderByUserId(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager
                .createQuery("DELETE FROM OrderEntity c WHERE c.id like :id");
        query.setParameter("id", id);
        if (query.executeUpdate() == 1) {
            entityManager.getTransaction().commit();
            return true;
        } else {
            return false;
        }

    }

    @Override
    public OrderEntity addOrder(OrderEntity order) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(order);
        entityManager.getTransaction().commit();
        return order;
    }
}
