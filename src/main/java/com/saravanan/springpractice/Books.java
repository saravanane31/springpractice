package com.saravanan.springpractice;

import com.saravanan.springpractice.model.Author;
import org.springframework.jmx.export.annotation.ManagedMetric;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String isbn;
    private String publisher;

    @ManyToMany
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name="author_id"))
    private Set<Author> authorSet=new HashSet<>();

    public Books(String title, String isbn, String publisher, Set<Author> authorSet) {
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
        this.authorSet = authorSet;
    }

    public Books() {
    }

    public Books(String title, String isbn, String publisher) {

        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
    }

    public Set<Author> getAuthorSet() {
        return authorSet;
    }

    public void setAuthorSet(Set<Author> authorSet) {
        this.authorSet = authorSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
