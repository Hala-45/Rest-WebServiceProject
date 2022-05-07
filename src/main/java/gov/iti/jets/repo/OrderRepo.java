package gov.iti.jets.repo;

import java.util.List;
import gov.iti.jets.repo.entities.OrderEntity;

public interface OrderRepo {

    List<OrderEntity> getAllOrderProductsByUserId(int userId);

    boolean deleteOrderByUserId(int id);

    OrderEntity addOrder(OrderEntity order);

    OrderEntity findOrderById(int id);

    OrderEntity updateOrder(OrderEntity order);
}
