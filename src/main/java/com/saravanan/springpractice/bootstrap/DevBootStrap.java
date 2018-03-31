package com.saravanan.springpractice.bootstrap;

import com.saravanan.springpractice.model.Author;
import com.saravanan.springpractice.model.Books;
import com.saravanan.springpractice.repository.AuthorRepository;
import com.saravanan.springpractice.repository.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;


    public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){
        Author author = new Author("Saravanan","Elangovan");
        Books ddd = new Books("Springboot cookbook","1234","Seduraman");
        author.getBooks().add(ddd);
        ddd.getAuthorSet().add(author);

        authorRepository.save(author);
        bookRepository.save(ddd);

        Author author1 = new Author("Selvakumar","Elangovan");
        Books dddBooks = new Books("Mechanical Engineering","3456","Seduraman");
        author.getBooks().add(dddBooks);
        ddd.getAuthorSet().add(author1);

        authorRepository.save(author1);
        bookRepository.save(dddBooks);
    }
}
