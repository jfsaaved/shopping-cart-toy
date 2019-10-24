package com.jfsaaved.shopping.controller;

import com.jfsaaved.shopping.service.CDService;
import com.jfsaaved.shopping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CDController {

    @Autowired
    private CDService cdService;

    @Autowired
    private UserService userService;

    @GetMapping("/cds")
    public String list(Model model, @RequestParam(value = "filter", required = false) String filter){
        model.addAttribute("controllerName", "CDs");
        model.addAttribute("cds", cdService.filterByTitleAndArtist(filter));
        return "cds/list";
    }

    @RequestMapping("/cds/{id}")
    public String view(Model model, @PathVariable Long id){
        model.addAttribute("userShoppingCartID", userService.getUserShoppingCart(Long.valueOf(10)).getId());
        model.addAttribute("cd", cdService.get(id));
        return "cds/view";
    }

}
