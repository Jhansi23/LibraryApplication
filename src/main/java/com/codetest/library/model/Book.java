package com.codetest.library.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "Book")
public class Book  implements Serializable {

    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Title")
    @NotBlank(message = "Enter a title ")
    private String title;

    @Column(name = "Genre")
    @NotBlank(message = "Enter a genre ")
    private String genre;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AuthorId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Author author;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @JsonIgnore
    public Author getAuthor() {
        return author;
    }

    @JsonIgnore
    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}