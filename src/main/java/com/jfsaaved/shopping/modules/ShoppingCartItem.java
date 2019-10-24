package com.jfsaaved.shopping.modules;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ShoppingCartItem {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(targetEntity = Item.class)
    private Item item;
    private Date dateAdded;
    private int quantity;

    @ManyToOne(targetEntity = ShoppingCart.class)
    private ShoppingCart shoppingCart;

    public ShoppingCartItem(){

    }

    public ShoppingCartItem(Item item,Date dateAdded, ShoppingCart shoppingCart) {
        this.item = item;
        this.dateAdded = dateAdded;
        this.shoppingCart = shoppingCart;
        this.quantity = 1;
    }

    public ShoppingCartItem(Item item,Date dateAdded, ShoppingCart shoppingCart, int quantity) {
        this.item = item;
        this.dateAdded = dateAdded;
        this.shoppingCart = shoppingCart;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
