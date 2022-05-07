package gov.iti.jets.repo.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "order_details")
public class OrderDetailsEntity implements Serializable {

    @EmbeddedId
    private OrderDetailsID id;
    private BigDecimal price = BigDecimal.ZERO;
    private int quantity;

    @ManyToOne
   @MapsId("userId")
    @JoinColumn(name = "user_id")
    private CustomerEntity user;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    public OrderDetailsEntity() {

    }

    public OrderDetailsEntity(BigDecimal price, int quantity, CustomerEntity user, ProductEntity product,
            OrderEntity order, OrderDetailsID id) {
        this.price = price;
        this.quantity = quantity;
        this.user = user;
        this.product = product;
        this.order = order;
        this.id = id;
    }

    public OrderDetailsID getId() {
        return id;
    }

    public void setId(OrderDetailsID id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public CustomerEntity getUser() {
        return user;
    }

    public void setUser(CustomerEntity user) {
        this.user = user;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

}
