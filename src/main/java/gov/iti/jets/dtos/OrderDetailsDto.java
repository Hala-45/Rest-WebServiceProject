package gov.iti.jets.dtos;

import java.math.BigDecimal;

public class OrderDetailsDto {

    private int orderId;
    private ProductDto product;
    private int userId;
    private BigDecimal price;
    private int quantity;

    public OrderDetailsDto(int orderId, ProductDto product, int userId, BigDecimal price, int quantity) {
        this.orderId = orderId;
        this.product = product;
        this.userId = userId;
        this.price = price;
        this.quantity = quantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

}
