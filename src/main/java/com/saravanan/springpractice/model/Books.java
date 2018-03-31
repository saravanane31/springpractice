package com.saravanan.springpractice.model;

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

    @OneToOne
    private Publisher publisher;

    @ManyToMany
    @JoinTable(name = "author_books", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name="author_id"))
    private Set<Author> authorSet=new HashSet<>();

    public Books(String title, String isbn, Publisher publisher, Set<Author> authorSet) {
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
        this.authorSet = authorSet;
    }

    public Books() {
    }

    public Books(String title, String isbn, Publisher publisher) {

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

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}
