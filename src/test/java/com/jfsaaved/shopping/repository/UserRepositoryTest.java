package com.jfsaaved.shopping.repository;


import com.jfsaaved.shopping.modules.User;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;


@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private UserRepository userRepository;

    public UserRepositoryTest(){

    }

    @Test
    public void whenFindByName_theReturnUser() {
        // given
        User julian = new User("Julian Saavedra","123-423-4924","julian.saavedra@email.com", BigDecimal.valueOf(500.00),null);
        testEntityManager.persist(julian);
        testEntityManager.flush();

        // when
        User userFound = userRepository.findByName("Julian Saavedra");

        // then
        Assert.assertEquals(julian.getName(), (userFound.getName()));
    }
}