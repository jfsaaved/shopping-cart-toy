package com.jfsaaved.shopping.controller;

import com.jfsaaved.shopping.modules.Book;
import com.jfsaaved.shopping.modules.CD;
import com.jfsaaved.shopping.modules.Item;
import com.jfsaaved.shopping.service.BookService;
import com.jfsaaved.shopping.service.CDService;
import com.jfsaaved.shopping.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/items")
    public String list(Model model, @RequestParam(value = "filter", required =  false) String filter){
        model.addAttribute("controllerName", "All Items");
        model.addAttribute("items", itemService.filterByTitleAndAuthorAndArtist(filter));
        return "items/list";
    }

}
