package com.jfsaaved.shopping.repository;

import com.jfsaaved.shopping.modules.CD;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CDRepository extends CrudRepository<CD, Long> {
}
