package com.jfsaaved.shopping.repository;

import com.jfsaaved.shopping.modules.ShoppingCart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long> {
}
