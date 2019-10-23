package com.jfsaaved.shopping.service;

import com.jfsaaved.shopping.modules.Item;
import com.jfsaaved.shopping.modules.ShoppingCart;
import com.jfsaaved.shopping.repository.BookRepository;
import com.jfsaaved.shopping.repository.CDRepository;
import com.jfsaaved.shopping.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ShoppingCartService {

    private ShoppingCartRepository shoppingCartRepository;
    private BookRepository bookRepository;
    private CDRepository cdRepository;

    @Autowired
    public ShoppingCartService(BookRepository bookRepository, CDRepository cdRepository, ShoppingCartRepository shoppingCartRepository){
        this.bookRepository = bookRepository;
        this.cdRepository = cdRepository;
        this.shoppingCartRepository = shoppingCartRepository;
    }

    public Iterable<ShoppingCart> list(){
        return shoppingCartRepository.findAll();
    }

    public ShoppingCart get(Long id){
        return shoppingCartRepository.findById(id).orElse(null);
    }

    public void update(Long sId, Long id){
        ShoppingCart sc = shoppingCartRepository.findById(sId).orElse(null);
        if(sc != null)sc.addItem(id);
        shoppingCartRepository.save(sc);
    }

    public void save(ShoppingCart shoppingCart){
        shoppingCartRepository.save(shoppingCart);
    }
}
