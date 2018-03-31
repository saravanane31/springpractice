package com.saravanan.springpractice.repository;

import com.saravanan.springpractice.model.Books;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Books, Long> {
}
