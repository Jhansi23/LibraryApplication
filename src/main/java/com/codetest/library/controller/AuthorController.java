package com.codetest.library.controller;

import com.codetest.library.model.Author;
import com.codetest.library.model.Book;
import com.codetest.library.service.AuthorService;
import com.codetest.library.service.BookService;
import org.hibernate.validator.constraints.ParameterScriptAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.nio.file.Files;
import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;
    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public List<Author> getAllAuthors(){
        return authorService.getAllAuthors();

    }
    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable Long id){
        return authorService.getAuthorById(id);
    }

    @PostMapping("/")
    public Author createAuthor(@RequestBody Author author){
        return authorService.createAuthor(author);
    }

    @PostMapping("/{id}/book")
    public Book createBookForAuthor(@PathVariable Long id, @RequestBody Book book){
        return bookService.createBook(id,book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAuthor(@PathVariable Long id, @RequestBody Author author){
        authorService.update(id, author);
       return new ResponseEntity<>("Updated successful", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable Long id){
        authorService.delete(id);
        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
    }
}
