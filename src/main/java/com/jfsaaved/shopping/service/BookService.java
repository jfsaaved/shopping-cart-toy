package com.jfsaaved.shopping.service;

import com.jfsaaved.shopping.modules.Book;
import com.jfsaaved.shopping.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public void save(Book book){
        bookRepository.save(book);
    }

    public Book get(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public void delete(Book book){
        bookRepository.delete(book);
    }

    public Iterable<Book> list(){
        return bookRepository.findAll();
    }

}
