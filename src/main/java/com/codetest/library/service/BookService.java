package com.codetest.library.service;

import com.codetest.library.exception.ResourceNotFoundException;
import com.codetest.library.model.Author;
import com.codetest.library.model.Book;
import com.codetest.library.repo.AuthorRepository;
import com.codetest.library.repo.BookRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BookService {
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    public Book createBook(Long authorId, Book book) {
        Set<Book> books = new HashSet<>();
        Author author1 = new Author();

        Optional<Author> byId = authorRepository.findById(authorId);
        if (!byId.isPresent()) {
            throw new ResourceNotFoundException("Author with id " + authorId + " does not exist");
        }
        Author author = byId.get();

        //tie Author to Book
        book.setAuthor(author);
        Book book1 = bookRepository.save(book);

        //tie Book to Author
        books.add(book1);
        author1.setBooks(books);

        return book1;

    }

}
