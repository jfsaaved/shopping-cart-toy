package com.jfsaaved.shopping.repository;

import com.jfsaaved.shopping.modules.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
}
