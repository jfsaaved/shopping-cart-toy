package com.jfsaaved.shopping;

import com.jfsaaved.shopping.modules.Book;
import com.jfsaaved.shopping.modules.CD;
import com.jfsaaved.shopping.modules.ShoppingCart;
import com.jfsaaved.shopping.modules.User;
import com.jfsaaved.shopping.service.BookService;
import com.jfsaaved.shopping.service.CDService;
import com.jfsaaved.shopping.service.ShoppingCartService;
import com.jfsaaved.shopping.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;

@Component
public class DataLoader {

    private BookService bookService;
    private CDService cdService;
    private ShoppingCartService shoppingCartService;
    private UserService userService;
    private ResourceLoader resourceLoader;

    private Logger logger = LoggerFactory.getLogger(DataLoader.class);

    private final String token = "    ";

    @Autowired
    public DataLoader(BookService bookService, CDService cdService, ShoppingCartService shoppingCartService, UserService userService,
                      ResourceLoader resourceLoader) {
        this.bookService = bookService;
        this.cdService = cdService;
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
        this.resourceLoader = resourceLoader;
    }

    @PostConstruct
    public void loadData(){
        loadUsers();
        loadContents();
        loadDiscounts();
    }

    private ArrayList<String> getAuthors(String authors){
        String[] by = authors.split(",");
        ArrayList<String> byList = new ArrayList<>();
        Collections.addAll(byList, by);
        return byList;
    }

    private String getAuthorString(String authors){
        String[] by = authors.split(",");
        ArrayList<String> byList = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for(String item : by){
            if(first) {
                sb.append(item);
                first = false;
            } else  sb.append( " & " ).append(item);
        }

        return sb.toString();
    }

    private void loadContents() {
        Resource resource = resourceLoader.getResource("classpath:static/csv/contents.dat");
        try (BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))){
            String temp = br.readLine();

            while(temp != null){
                String[] array = temp.split(token);
                temp = br.readLine();
                if(array[0].equals("Book")) bookService.save(parseAsBook(array));
                else if(array[0].equals("CD")) cdService.save(parseAsCD(array));
            }

        } catch (IOException e) {
            logger.error(e.getMessage(), e);

            Book book = new Book("Test", "12391ure0jas");
            bookService.save(book);
        }
    }

    private void loadDiscounts(){
        Book book = bookService.get((long) 3);
        book.setDiscount(BigDecimal.valueOf(0.25));
        book.setDiscountEligible(true);
        bookService.save(book);
    }

    private Book parseAsBook(String[] array){
        // itemType,isbn,name,author,description,price,imgurl
        //  0        1    2    3        4         5      6
        Book book = new Book(array[2], array[1])
                .withPrice(BigDecimal.valueOf(Double.parseDouble(array[5])))
                .withAuthor(getAuthorString(array[3]))
                .withImgUrl(array[6])
                .withDescription(array[4])
                .withAuthors(getAuthors(array[3]));
        return book;
    }

    private CD parseAsCD(String[] array){
        // itemType,asin,name,author,label,price,imgurl
        //  0        1    2    3        4    5      6
        CD cd = new CD(array[2], array[1])
                .withPrice(BigDecimal.valueOf(Double.parseDouble(array[5])))
                .withArtist(getAuthorString(array[3]))
                .withImgUrl(array[6])
                .withLabel(array[4])
                .withArtists(getAuthors(array[3]));
        return cd;
    }

    private void loadUsers(){
        ShoppingCart shoppingCart = new ShoppingCart();
        User user = new User("Julian Saavedra","123-423-4924","julian.saavedra@email.com", BigDecimal.valueOf(500.00),shoppingCart);

        shoppingCartService.save(shoppingCart);
        userService.save(user);
    }

}
