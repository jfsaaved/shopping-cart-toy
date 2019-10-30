package com.jfsaaved.shopping.service;

import com.jfsaaved.shopping.modules.Book;
import com.jfsaaved.shopping.repository.BookRepository;
import com.jfsaaved.shopping.service.specification.BookSpecification;
import com.jfsaaved.shopping.service.specification.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public ArrayList<Book> filterByTitleAndAuthor(String filter){
        if(filter == null) filter = "";
        ArrayList<Book> result = new ArrayList<>();
        for(Book book : bookRepository.findAll()){
            if(book.getName().toLowerCase().contains(filter.toLowerCase())
                || book.getAuthor().toLowerCase().contains(filter.toLowerCase())){
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> filterByAttribute(String attribute, String filter){
        BookSpecification bSpec = new BookSpecification(new SearchCriteria(attribute, ":", filter));
        return bookRepository.findAll(bSpec);
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
