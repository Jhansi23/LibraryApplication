package com.codetest.library.service;

import com.codetest.library.exception.ResourceNotFoundException;
import com.codetest.library.model.Author;
import com.codetest.library.repo.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    public Author getAuthorById(Long id) {
        Optional<Author> author = authorRepository.findById(id);
        if(author.isPresent()){
            return author.get();
        }
        throw new ResourceNotFoundException("Author not found with Id:"+id);
    }

    public Author createAuthor(Author author) {
       return authorRepository.save(author);
    }

    public void update(Long id, Author author) {
        author.setId(id);
        authorRepository.save(author);
    }

    public void delete(Long id) {
        Author author = new Author();
        author.setId(id);
        authorRepository.delete(author);
    }
}
