package com.jfsaaved.shopping.controller;

import com.jfsaaved.shopping.modules.ShoppingCartItem;
import com.jfsaaved.shopping.modules.User;
import com.jfsaaved.shopping.service.ShoppingCartService;
import com.jfsaaved.shopping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ShoppingCartService shoppingCartService;

    @RequestMapping("/users/{userID}")
    public String view(Model model, @PathVariable(value="userID") Long userID,
                       @RequestParam(value="wallet", required = false) BigDecimal wallet,
                       @RequestParam(value="shoppingCartItems", required = false) String shoppingCartItems){
        User user = userService.getByID(userID);
        if(wallet!=null) {
            user.setWallet(wallet);
            user.getItemsOwned().add(new Date().toString() + " - " + shoppingCartItems);
            userService.save(user);
            shoppingCartService.emptyShoppingCart(user.getShoppingCart().getId());
        }
        model.addAttribute("controllerName", "Account");
        model.addAttribute("user", userService.getByID(userID));
        model.addAttribute("itemsOwned", userService.getByID(userID).getItemsOwned());
        return "users/view";
    }

}
