package com.jfsaaved.shopping.controller;

import com.jfsaaved.shopping.modules.Book;
import com.jfsaaved.shopping.modules.CD;
import com.jfsaaved.shopping.modules.Item;
import com.jfsaaved.shopping.service.BookService;
import com.jfsaaved.shopping.service.CDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class ItemController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CDService cdService;

    @GetMapping("/items")
    public String list(Model model){
        ArrayList<Item> items = new ArrayList<>();
        for(Book b : bookService.list())
            items.add(b);
        for(CD c : cdService.list())
            items.add(c);
        model.addAttribute("controllerName", "All Items");
        model.addAttribute("items", items);
        return "items/list";
    }

}
