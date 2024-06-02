package com.hypad.LibraryManagementSystem.service;

import com.hypad.LibraryManagementSystem.model.Book;
import com.hypad.LibraryManagementSystem.repository.InMemBookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InMemBooksService implements BooksService{
    private final InMemBookRepository repository;
    @Override
    public List<Book> findAllBooks() {
        return repository.findAllBooks();
    }

    @Override
    public Book addBook(Book book) {
        return repository.addBook(book);
    }

    @Override
    public Book updateBook(Book book) {
        return repository.updateBook(book);
    }

    @Override
    public Book findByBookName(String name) {
        return repository.findByBookName(name);
    }

    @Override
    public void deleteBook(String name) {
        repository.deleteBook(name);
    }
}
