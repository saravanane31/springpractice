package com.saravanan.springpractice.repository;

import com.saravanan.springpractice.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
