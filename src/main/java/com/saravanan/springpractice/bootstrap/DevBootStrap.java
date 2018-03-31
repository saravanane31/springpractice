package com.saravanan.springpractice.bootstrap;

import com.saravanan.springpractice.model.Author;
import com.saravanan.springpractice.model.Books;
import com.saravanan.springpractice.model.Publisher;
import com.saravanan.springpractice.repository.AuthorRepository;
import com.saravanan.springpractice.repository.BookRepository;
import com.saravanan.springpractice.repository.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        Publisher publisher = new Publisher();
        publisher.setName("seduraman");

        publisherRepository.save(publisher);

        Author author = new Author("Saravanan","Elangovan");
        Books ddd = new Books("Springboot cookbook","1234",publisher);
        author.getBooks().add(ddd);
        ddd.getAuthorSet().add(author);

        authorRepository.save(author);
        bookRepository.save(ddd);

        Author author1 = new Author("Selvakumar","Elangovan");
        Books dddBooks = new Books("Mechanical Engineering","3456", publisher);
        author.getBooks().add(dddBooks);
        dddBooks.getAuthorSet().add(author1);

        authorRepository.save(author1);
        bookRepository.save(dddBooks);
    }
}
