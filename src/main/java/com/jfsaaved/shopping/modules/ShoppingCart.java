package com.jfsaaved.shopping.modules;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ShoppingCart {

    @GeneratedValue
    @Id
    private Long id;
    private ArrayList<Long> itemsToBuy;

    public ShoppingCart(){
        itemsToBuy = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void addItem(Long id){
        itemsToBuy.add(id);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ArrayList<Long> getItemsToBuy() {
        return itemsToBuy;
    }

    public void setItemsToBuy(ArrayList<Long> itemsToBuy) {
        this.itemsToBuy = itemsToBuy;
    }



}
