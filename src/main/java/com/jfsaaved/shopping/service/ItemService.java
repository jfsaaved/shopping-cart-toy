package com.jfsaaved.shopping.service;

import com.jfsaaved.shopping.modules.Book;
import com.jfsaaved.shopping.modules.CD;
import com.jfsaaved.shopping.modules.Item;
import com.jfsaaved.shopping.repository.BookRepository;
import com.jfsaaved.shopping.repository.CDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Service
public class ItemService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CDRepository cdRepository;

    public ArrayList<Item> filterByTitleAndAuthorAndArtist(String filter){
        if(filter == null) filter = "";
        ArrayList<Item> result = new ArrayList<>();
        for(Book book : bookRepository.findAll()){
            if(book.getName().toLowerCase().contains(filter.toLowerCase())
                || book.getAuthor().toLowerCase().contains(filter.toLowerCase())){
                result.add(book);
            }
        }

        for(CD cd : cdRepository.findAll()){
            if(cd.getName().toLowerCase().contains(filter.toLowerCase())
                || cd.getArtist().toLowerCase().contains(filter.toLowerCase())){
                result.add(cd);
            }
        }
        return result;
    }

}
