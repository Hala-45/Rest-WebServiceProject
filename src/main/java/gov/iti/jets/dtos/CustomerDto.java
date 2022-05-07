
package gov.iti.jets.dtos;

import java.io.Serializable;


public class CustomerDto implements Serializable {

    private int id;
    private String userName;
    private String email;
    private String pass;
//    private Set<CartEntity> cart;
//    private Set<OrderDetailsEntity> orderDetails ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

//    public Set<CartEntity> getCart() {
//        return cart;
//    }
//
//    public void setCart(Set<CartEntity> cart) {
//        this.cart = cart;
//    }
//
//    public Set<OrderDetailsEntity> getOrderDetails() {
//        return orderDetails;
//    }
//
//    public void setOrderDetails(Set<OrderDetailsEntity> orderDetails) {
//        this.orderDetails = orderDetails;
//    }


}
