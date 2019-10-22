package com.jfsaaved.shopping.controller;

import com.jfsaaved.shopping.modules.Book;
import com.jfsaaved.shopping.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public String list(Model model, @RequestParam(value = "filter", required =  false) String filter){
        model.addAttribute("controllerName", "Books");
        model.addAttribute("books", bookService.filterByTitleAndAuthor(filter));
        return "books/list";
    }

    @RequestMapping("/books/{id}")
    public String view(@PathVariable Long id, Model model){
        ArrayList<Book> books = new ArrayList<>();
        books.add(bookService.get(id));
        model.addAttribute("books", books);
        return "books/list";
    }

    @RequestMapping("/books/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        model.addAttribute("book",bookService.get(id));
        return "books/edit";
    }

    @RequestMapping( value = "/books/save", method = RequestMethod.POST )
    public String saveE(@Valid Book book, BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()) {
            model.addAttribute("books",bookService.list());
            return "books/edit";
        } else {
            bookService.save(book);
            return "redirect:/books";
        }
    }

}
