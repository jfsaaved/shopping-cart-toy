package com.jfsaaved.shopping.service;

import com.jfsaaved.shopping.modules.Item;
import com.jfsaaved.shopping.modules.ShoppingCart;
import com.jfsaaved.shopping.modules.ShoppingCartItem;
import com.jfsaaved.shopping.repository.ShoppingCartItemRepository;
import com.jfsaaved.shopping.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class ShoppingCartService {

    private ShoppingCartRepository shoppingCartRepository;
    private ShoppingCartItemRepository shoppingCartItemRepository;

    @Autowired
    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository, ShoppingCartItemRepository shoppingCartItemRepository){
        this.shoppingCartRepository = shoppingCartRepository;
        this.shoppingCartItemRepository = shoppingCartItemRepository;
    }

    public void save(ShoppingCart shoppingCart){
        shoppingCartRepository.save(shoppingCart);
    }

    public void saveItem(Long shoppingCartID, Item item){
        ShoppingCart shoppingCartReference = shoppingCartRepository.findById(shoppingCartID).orElse(null);
        ShoppingCartItem newItem = new ShoppingCartItem(item, new Date(), shoppingCartReference);

        boolean added = false;
        for (ShoppingCartItem shoppingCartItem : shoppingCartReference.getShoppingCartItems()) {
            if (shoppingCartItem.getItem().getId().equals(item.getId())) {
                newItem = shoppingCartItem;
                newItem.setQuantity(newItem.getQuantity() + 1);
                shoppingCartItemRepository.save(newItem);
                added = true;
            }
        }

        if(!added) {
            shoppingCartItemRepository.save(newItem);
            shoppingCartReference.getShoppingCartItems().add(newItem);
            shoppingCartRepository.save(shoppingCartReference);
        }
    }

    public ShoppingCart getShoppingCart(Long id){
        return shoppingCartRepository.findById(id).orElse(null);
    }

    public List<ShoppingCartItem> getShoppingCartItems(Long shoppingCartID){
        return shoppingCartRepository.findById(shoppingCartID).orElse(null).getShoppingCartItems();
    }

}
