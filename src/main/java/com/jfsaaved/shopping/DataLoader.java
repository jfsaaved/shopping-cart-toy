package com.jfsaaved.shopping;

import com.jfsaaved.shopping.modules.Book;
import com.jfsaaved.shopping.modules.CD;
import com.jfsaaved.shopping.modules.ShoppingCart;
import com.jfsaaved.shopping.modules.User;
import com.jfsaaved.shopping.modules.enums.BookAvailability;
import com.jfsaaved.shopping.modules.enums.CDGenre;
import com.jfsaaved.shopping.service.BookService;
import com.jfsaaved.shopping.service.CDService;
import com.jfsaaved.shopping.service.ShoppingCartService;
import com.jfsaaved.shopping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.math.BigDecimal;

@Component
public class DataLoader {

    private BookService bookService;
    private CDService cdService;
    private ShoppingCartService shoppingCartService;
    private UserService userService;

    @Autowired
    public DataLoader(BookService bookService, CDService cdService, ShoppingCartService shoppingCartService, UserService userService) {
        this.bookService = bookService;
        this.cdService = cdService;
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
    }

    @PostConstruct
    public void loadData(){
        loadBooks();
        loadCDs();
        loadShoppingCarts();
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

    private void loadCDs(){
        CD cd1 = new CD("Portrait in Jazz","B0012X6FR6")
                .withPrice(BigDecimal.valueOf(16.75))
                .withArtist("Bill Evans")
                .withCDGenre(CDGenre.JAZZ)
                .withLabel("Universal Music Canada")
                .withImgUrl("https://images-na.ssl-images-amazon.com/images/I/71dFfKovRmL._SL1199_.jpg");

        CD cd2 = new CD("Kind of Blue", "B0041TM5OU")
                .withPrice(BigDecimal.valueOf(34.10))
                .withArtist("Miles Davis")
                .withCDGenre(CDGenre.JAZZ)
                .withLabel("Sony Music Canada Entertainment Inc.")
                .withImgUrl("https://images-na.ssl-images-amazon.com/images/I/81CP1j-zprL._SL1500_.jpg");

        CD cd3 = new CD("Blue Train", "B00HG30CD4")
                .withPrice(BigDecimal.valueOf(24.99))
                .withArtist("John Coltrane")
                .withCDGenre(CDGenre.JAZZ)
                .withLabel("Universal Music Canada")
                .withImgUrl("https://images-na.ssl-images-amazon.com/images/I/81RQvViP0dL._SL1400_.jpg");

        cdService.save(cd1);
        cdService.save(cd2);
        cdService.save(cd3);
    }

    private void loadShoppingCarts(){
        ShoppingCart shoppingCart = new ShoppingCart();
        User user = new User("Julian","123","julian@email.com", BigDecimal.valueOf(500.00),shoppingCart);

        shoppingCartService.save(shoppingCart);
        userService.save(user);
    }

}
