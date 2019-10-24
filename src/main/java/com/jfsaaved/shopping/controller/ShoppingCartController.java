package com.jfsaaved.shopping.controller;

import com.jfsaaved.shopping.modules.ShoppingCartItem;
import com.jfsaaved.shopping.service.ItemService;
import com.jfsaaved.shopping.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class ShoppingCartController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ShoppingCartService shoppingCartService;

    @RequestMapping("/shoppingCart/{shoppingCartID}")
    public String add(Model model, @PathVariable Long shoppingCartID, @RequestParam(value="add", required=false) Long itemID){
        if(itemID != null) { // we add an item
            shoppingCartService.saveItem(shoppingCartID,itemService.get(itemID));
        }
        PagedListHolder<ShoppingCartItem> pagedShoppingCartItems = new PagedListHolder<>(shoppingCartService.getShoppingCartItems(shoppingCartID));
        model.addAttribute("controllerName", "Shopping Cart");
        model.addAttribute("contents",pagedShoppingCartItems);
        return "shopping-cart/view";
    }


}
