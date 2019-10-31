package com.jfsaaved.shopping.controller;

import com.jfsaaved.shopping.modules.ShoppingCartItem;
import com.jfsaaved.shopping.service.ItemService;
import com.jfsaaved.shopping.service.ShoppingCartService;
import com.jfsaaved.shopping.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ShoppingCartController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(ShoppingCartController.class);

    @GetMapping("/shoppingCart/{shoppingCartID}")
    public String add(Model model, @PathVariable Long shoppingCartID, @RequestParam(value="quantity", required = false) Integer quantity, @RequestParam(value="add", required=false) Long itemID){
        if(itemID != null) { // we add an item
            if(quantity != null)
                shoppingCartService.saveItem(shoppingCartID,itemService.get(itemID), quantity);
            else
                shoppingCartService.saveItem(shoppingCartID,itemService.get(itemID), 1);
        }

        BigDecimal total = new BigDecimal(0);
        List<String> listOfItemIDs = new ArrayList<>();
        for(ShoppingCartItem item : shoppingCartService.getShoppingCartItems(shoppingCartID)){
            listOfItemIDs.add(item.getItem().getName() + " x" + item.getQuantity() + " @ $" + (item.getItem().getPrice().multiply(BigDecimal.valueOf(item.getQuantity()))));
            total = total.add(item.getItem().getPrice().multiply(BigDecimal.valueOf(item.getQuantity())));

        }

        PagedListHolder<ShoppingCartItem> pagedShoppingCartItems = new PagedListHolder<>(shoppingCartService.getShoppingCartItems(shoppingCartID));
        model.addAttribute("controllerName", "Shopping Cart");
        model.addAttribute("contents",pagedShoppingCartItems);
        model.addAttribute("total",total);
        model.addAttribute("listOfIDs", listOfItemIDs);
        model.addAttribute("wallet",userService.getByID(Long.valueOf(2)).getWallet());
        return "shopping-cart/view";
    }


}
