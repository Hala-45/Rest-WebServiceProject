package gov.iti.jets.repo;

import java.util.List;

import gov.iti.jets.repo.entities.CartEntity;

public interface CartRepo {

    List<CartEntity> getUserCartByUserId(int userId);
    CartEntity updateCart(CartEntity cartEntity, int userId);

}
