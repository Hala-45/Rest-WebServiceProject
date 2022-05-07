package gov.iti.jets.repo.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class OrderDetailsID implements Serializable {

    @Column(name = "product_id")
    long productId;

    @Column(name = "user_id")
    int userId;

    @Column(name = "order_id")
    int orderId;

    public OrderDetailsID() {

    }

    public OrderDetailsID(long productId, int userId, int orderId) {
        this.productId = productId;
        this.userId = userId;
        this.orderId = orderId;
    }

}
