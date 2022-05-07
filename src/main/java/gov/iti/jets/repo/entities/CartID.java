package gov.iti.jets.repo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable

public class CartID implements Serializable {
    @Column(name = "order_id")
    long productId;
    @Column(name = "user_id")
    int userId;

    public CartID() {
    }

    public CartID(long productId, int userId) {
        this.productId = productId;
        this.userId = userId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartID cartID = (CartID) o;
        return productId == cartID.productId && userId == cartID.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, userId);
    }
}



