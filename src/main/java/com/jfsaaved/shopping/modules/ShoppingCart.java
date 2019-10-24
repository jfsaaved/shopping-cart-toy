package com.jfsaaved.shopping.modules;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ShoppingCart {

    @GeneratedValue
    @Id
    private Long id;

    @OneToMany(targetEntity = ShoppingCartItem.class)
    private List<ShoppingCartItem> shoppingCartItems;

    public ShoppingCart(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ShoppingCartItem> getShoppingCartItems() {
        return shoppingCartItems;
    }

    public List<Long> getShoppingCartItemReferences(){
        List<Long> result = new ArrayList<>();
        for(ShoppingCartItem item : shoppingCartItems) {
            result.add(item.getId());
        }
        return result;
    }

    public void setShoppingCartItems(List<ShoppingCartItem> shoppingCartItems) {
        this.shoppingCartItems = shoppingCartItems;
    }

}
