package com.jfsaaved.shopping.modules;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @GeneratedValue
    @Id
    private Long id;
    private String name;
    private String phone;
    private String email;
    private BigDecimal wallet;

    @OneToOne(targetEntity = ShoppingCart.class)
    private ShoppingCart shoppingCart;

    @Lob
    private ArrayList<String> itemsOwned;

    public User(){

    }

    public User (String name, String phone, String email, BigDecimal wallet, ShoppingCart shoppingCart){
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.wallet = wallet;
        this.shoppingCart = shoppingCart;
        this.itemsOwned = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getWallet() {
        return wallet;
    }

    public void setWallet(BigDecimal wallet) {
        this.wallet = wallet;
    }

    public ArrayList<String> getItemsOwned() {
        return itemsOwned;
    }

    public void setItemsOwned(ArrayList<String> itemsOwned) {
        this.itemsOwned = itemsOwned;
    }

}
