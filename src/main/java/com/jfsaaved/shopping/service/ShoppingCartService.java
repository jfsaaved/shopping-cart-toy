package com.jfsaaved.shopping.service;

import com.jfsaaved.shopping.modules.Item;
import com.jfsaaved.shopping.modules.ShoppingCart;
import com.jfsaaved.shopping.modules.ShoppingCartItem;
import com.jfsaaved.shopping.repository.ShoppingCartItemRepository;
import com.jfsaaved.shopping.repository.ShoppingCartRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class ShoppingCartService {

    private ShoppingCartRepository shoppingCartRepository;
    private ShoppingCartItemRepository shoppingCartItemRepository;

    private Logger logger = LoggerFactory.getLogger(ShoppingCartService.class);

    @Autowired
    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository, ShoppingCartItemRepository shoppingCartItemRepository){
        this.shoppingCartRepository = shoppingCartRepository;
        this.shoppingCartItemRepository = shoppingCartItemRepository;
    }

    public void save(ShoppingCart shoppingCart){
        shoppingCartRepository.save(shoppingCart);
    }

    public void saveItem(Long shoppingCartID, Item item, int quantity){
        ShoppingCart shoppingCartReference = shoppingCartRepository.findById(shoppingCartID).orElse(null);
        if(shoppingCartReference != null) {
            ShoppingCartItem newItem = new ShoppingCartItem(item, new Date(), shoppingCartReference, quantity);

            boolean added = false;
            for (ShoppingCartItem shoppingCartItem : shoppingCartReference.getShoppingCartItems()) {
                if (shoppingCartItem.getItem().getId().equals(item.getId())) {
                    newItem = shoppingCartItem;
                    newItem.setQuantity(newItem.getQuantity() + quantity);
                    shoppingCartItemRepository.save(newItem);
                    added = true;
                }
            }

            if (!added) {
                shoppingCartItemRepository.save(newItem);
                shoppingCartReference.getShoppingCartItems().add(newItem);
                shoppingCartRepository.save(shoppingCartReference);
            }
        } else {
            logger.error("NULL ShoppingCart");
        }
    }

    public ShoppingCart getShoppingCart(Long id){
        return shoppingCartRepository.findById(id).orElse(null);
    }

    public List<ShoppingCartItem> getShoppingCartItems(Long shoppingCartID){
        ShoppingCart shoppingCart = shoppingCartRepository.findById(shoppingCartID).orElse(null);
        if(shoppingCart != null){
            return shoppingCart.getShoppingCartItems();
        } else {
            return null;
        }
    }

    public void emptyShoppingCart(Long shoppingCartID){
        ShoppingCart shoppingCart = shoppingCartRepository.findById(shoppingCartID).orElse(null);
        if(shoppingCart != null) {
            shoppingCart.getShoppingCartItems().clear();
            shoppingCartRepository.save(shoppingCart);
        } else {
            logger.error("NULL ShoppingCart");
        }
    }

}
