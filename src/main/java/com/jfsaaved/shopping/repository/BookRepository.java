package com.jfsaaved.shopping.repository;

import com.jfsaaved.shopping.modules.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

}
