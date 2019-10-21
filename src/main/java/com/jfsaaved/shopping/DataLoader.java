package com.jfsaaved.shopping;

import com.jfsaaved.shopping.modules.Book;
import com.jfsaaved.shopping.modules.enums.BookAvailability;
import com.jfsaaved.shopping.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.math.BigDecimal;

@Component
public class DataLoader {

    private BookService bookService;

    @Autowired
    public DataLoader(BookService bookService) {
        this.bookService = bookService;
    }

    @PostConstruct
    public void loadDate(){
        loadBooks();
    }

    private void loadBooks() {
        Book book1 = new Book("Spring Boot In Action",
                "9781617292545")
                .withPrice(BigDecimal.valueOf(35.99))
                .withAuthor("Craig Walls")
                .withBookAvailability(BookAvailability.ELECTRONIC)
                .withImgUrl("http://t2.gstatic.com/images?q=tbn:ANd9GcQF3IMqPXyLb7pQz94LXfF3I_ysxj-9HrcdT-t_zcron181j3uN");

        Book book2 = new Book("Java How to Program, Early Objects (11th Edition)",
                "9780134743356")
                .withPrice(BigDecimal.valueOf(133.18))
                .withAuthor("Paul Deitel")
                .withBookAvailability(BookAvailability.ELECTRONIC)
                .withImgUrl("https://images-na.ssl-images-amazon.com/images/I/51frYIzwS1L._SX379_BO1,204,203,200_.jpg");

        Book book3 = new Book("Java: How to Program, 8th Edition",
                "9781617292545")
                .withPrice(BigDecimal.valueOf(9.97))
                .withAuthor("Paul Deitel")
                .withImgUrl("https://images-na.ssl-images-amazon.com/images/I/61qu2GwFyUL._SX383_BO1,204,203,200_.jpg");

        Book book4 = new Book("Java in easy steps",
                "9781840788730")
                .withPrice(BigDecimal.valueOf(15.99))
                .withAuthor("Mike McGrath")
                .withPages(192)
                .withImgUrl("https://images-na.ssl-images-amazon.com/images/I/51DFCXTTYkL._SX408_BO1,204,203,200_.jpg");

        Book book5 = new Book("Java in easy steps",
                "9781840788730")
                .withPrice(BigDecimal.valueOf(8.99))
                .withAuthor("Mike McGrath")
                .withPages(192)
                .withBookAvailability(BookAvailability.ELECTRONIC)
                .withImgUrl("https://images-na.ssl-images-amazon.com/images/I/51DFCXTTYkL._SX408_BO1,204,203,200_.jpg");


        bookService.save(book1);
        bookService.save(book2);
        bookService.save(book3);
        bookService.save(book4);
        bookService.save(book5);
    }

}
