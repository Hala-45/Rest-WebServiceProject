package gov.iti.jets.repo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "cart")

public class CartEntity {

    @EmbeddedId
    private CartID id;
    private int quantity;

    @ManyToOne(optional = false)
    @MapsId("userId")
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private CustomerEntity customer;

    @ManyToOne(optional = false)
    @MapsId("productId")
    @JoinColumn(name = "product_id",referencedColumnName = "id")
    private ProductEntity product;

    public CartID getId() {
        return id;
    }

    public void setId(CartID id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "CartEntity{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", customer=" + customer +
                ", product=" + product +
                '}';
    }
}
