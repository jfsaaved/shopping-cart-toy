package com.jfsaaved.shopping.service;

import com.jfsaaved.shopping.modules.ShoppingCart;
import com.jfsaaved.shopping.modules.User;
import com.jfsaaved.shopping.repository.ShoppingCartRepository;
import com.jfsaaved.shopping.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Optional;

@RunWith(SpringRunner.class)
public class UserServiceTest {

    @TestConfiguration
    static class UserServiceTestConfiguration {
        @Bean
        public UserService userService() {
            return new UserService();
        }
    }

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private ShoppingCartRepository shoppingCartRepository;

    public UserServiceTest(){

    }

    @Before
    public void setUp(){
        ShoppingCart shoppingCart = new ShoppingCart();
        User julian = new User("Julian Saavedra","123-423-4924","julian.saavedra@email.com", BigDecimal.valueOf(500.00),shoppingCart);
        Mockito.when(shoppingCartRepository.findById((long) 1)).thenReturn(Optional.of(shoppingCart));
        Mockito.when(userRepository.findByName("Julian Saavedra")).thenReturn(julian);
        Mockito.when(userRepository.findById((long) 1)).thenReturn(Optional.of(julian));
    }

    @Test
    public void whenValidName_thenUserShouldBeFound(){
        String name = "Julian Saavedra";
        User found = userService.findByName(name);

        Assert.assertEquals(name, found.getName());
    }

    @Test
    public void whenValidID_thenUserShouldBeFound(){
        Long id = (long) 1;

        String name = "Julian Saavedra";
        User found = userService.getByID(id);

        Assert.assertEquals(name, found.getName());
    }

    @Test
    public void whenInvalidID_thenShouldReturnNull(){
        Long id = (long) 2;

        User found = userService.getByID(id);

        Assert.assertEquals(null, found);
    }

    @Test
    public void whenValiID_thenShouldReturnValidShoppingCart(){
        Long id = (long) 1;

        ShoppingCart shoppingCart = userService.getByID(id).getShoppingCart();

        Assert.assertNotNull(shoppingCart);
    }

}