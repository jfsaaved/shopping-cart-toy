package com.jfsaaved.shopping.controller;

import com.jfsaaved.shopping.modules.Book;
import com.jfsaaved.shopping.service.BookService;
import com.jfsaaved.shopping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @GetMapping("/books")
    public String list(Model model, @RequestParam(value = "filter", required =  false) String filter){
        model.addAttribute("controllerName", "Books");
        model.addAttribute("books", bookService.filterByTitleAndAuthor(filter));
        return "books/list";
    }

    @GetMapping("/books/{id}")
    public String view(Model model, @PathVariable Long id){
        model.addAttribute("userShoppingCartID", userService.getUserShoppingCart(Long.valueOf(2)).getId());
        model.addAttribute("book", bookService.get(id));
        return "books/view";
    }

}
