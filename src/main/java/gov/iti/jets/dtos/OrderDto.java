package gov.iti.jets.dtos;

import java.math.BigDecimal;


public class OrderDto {

    private String address;
    private String description;
    private String phoneNumber;
    private BigDecimal totalPrice;
    private String email;

    public OrderDto(String address, String description, String phoneNumber, BigDecimal totalPrice, String email) {
        this.address = address;
        this.description = description;
        this.phoneNumber = phoneNumber;
        this.totalPrice = totalPrice;
        this.email = email;
    }

    public OrderDto() {

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
