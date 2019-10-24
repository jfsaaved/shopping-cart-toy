package com.jfsaaved.shopping.repository;

import com.jfsaaved.shopping.modules.ShoppingCartItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartItemRepository extends CrudRepository<ShoppingCartItem, Long> {
}
