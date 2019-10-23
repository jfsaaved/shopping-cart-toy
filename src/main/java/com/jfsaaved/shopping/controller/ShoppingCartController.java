package com.jfsaaved.shopping.controller;

import com.jfsaaved.shopping.modules.Item;
import com.jfsaaved.shopping.service.ItemService;
import com.jfsaaved.shopping.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Controller
public class ShoppingCartController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ShoppingCartService shoppingCartService;

    @RequestMapping("/shoppingCart/{shoppingCartID}")
    public String add(Model model, @PathVariable Long shoppingCartID, @RequestParam(value="add", required=false) Long id){

        if(id != null) shoppingCartService.update(shoppingCartID,id);

        ArrayList<Item> items = new ArrayList<>();
        for(Long itemID : shoppingCartService.get(shoppingCartID).getItemsToBuy()) {
            items.add(itemService.get(itemID.longValue()));
        }

        PagedListHolder<Item> pagedItems = new PagedListHolder<>(items);
        model.addAttribute("controllerName", "Shopping Cart");
        model.addAttribute("contents", pagedItems);
        return "shopping-cart/view";
    }


}
