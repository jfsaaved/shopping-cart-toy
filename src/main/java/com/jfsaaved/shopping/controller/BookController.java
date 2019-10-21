package com.jfsaaved.shopping.controller;

import com.jfsaaved.shopping.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public String list(Model model){
        model.addAttribute("controllerName", "Book");
        model.addAttribute("books", bookService.list());
        return "books/list";
    }

}
