package com.saravanan.springpractice.repository;

import com.saravanan.springpractice.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
