package com.jfsaaved.shopping.service;

import com.jfsaaved.shopping.modules.ShoppingCart;
import com.jfsaaved.shopping.modules.User;
import com.jfsaaved.shopping.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void save(User user){
        userRepository.save(user);
    }

    public ShoppingCart getUserShoppingCart(Long userID){
        User user = userRepository.findById(userID).orElse(null);
        if(user != null){
            return user.getShoppingCart();
        } else {
            return null;
        }
    }

    public User findByName(String name){
        return userRepository.findByName(name);
    }

    public User getByID(Long id){
        return userRepository.findById(id).orElse(null);
    }
}
