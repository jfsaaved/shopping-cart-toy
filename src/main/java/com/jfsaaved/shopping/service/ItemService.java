package com.jfsaaved.shopping.service;

import com.jfsaaved.shopping.modules.Book;
import com.jfsaaved.shopping.modules.CD;
import com.jfsaaved.shopping.modules.Item;
import com.jfsaaved.shopping.modules.enums.ItemType;
import com.jfsaaved.shopping.repository.BookRepository;
import com.jfsaaved.shopping.repository.CDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ItemService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CDRepository cdRepository;

    public Item get(Long id) {
        ArrayList<Item> items = new ArrayList<>();
        for(Book b: bookRepository.findAll())
            items.add(b);
        for(CD c : cdRepository.findAll())
            items.add(c);

        Item result = null;
        for(Item item : items)
            if(item.getId().equals(id))
                result = item;
        return result;
    }

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
