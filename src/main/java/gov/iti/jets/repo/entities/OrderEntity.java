package gov.iti.jets.repo.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class OrderEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String description;

    private BigDecimal totalPrice = BigDecimal.ZERO;

    private String phoneNumber;

    private String email;

    @OneToMany(mappedBy = "order")
    private Set<OrderDetailsEntity> orderDetails = new HashSet<>();

    public OrderEntity(String description, BigDecimal totalPrice, String phoneNumber, String address,
            Set<OrderDetailsEntity> orderDetails) {
        this.description = description;
        this.totalPrice = totalPrice;
        this.phoneNumber = phoneNumber;
        this.orderDetails = orderDetails;
    }

    public OrderEntity(int id, String description, BigDecimal totalPrice, String phoneNumber, String email) {
        this.id = id;
        this.description = description;
        this.totalPrice = totalPrice;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public OrderEntity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<OrderDetailsEntity> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Set<OrderDetailsEntity> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", totalPrice=" + totalPrice +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
