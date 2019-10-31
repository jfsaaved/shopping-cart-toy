package com.jfsaaved.shopping.service;

import com.jfsaaved.shopping.modules.User;
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

    public UserServiceTest(){

    }

    @Before
    public void setUp(){
        User julian = new User("Julian Saavedra","123-423-4924","julian.saavedra@email.com", BigDecimal.valueOf(500.00),null);
        Mockito.when(userRepository.findByName("Julian Saavedra")).thenReturn(julian);
    }

    @Test
    public void whenValidName_thenUserShouldBeFound(){
        String name = "Julian Saavedra";
        User found = userService.findByName(name);

        Assert.assertEquals(found.getName(), name);
    }
}