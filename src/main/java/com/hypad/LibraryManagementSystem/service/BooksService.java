package com.hypad.LibraryManagementSystem.service;

import com.hypad.LibraryManagementSystem.model.Book;

import java.util.List;

public interface BooksService{
    List<Book> findAllBooks();

    Book addBook(Book book);

    Book updateBook(Book book);

    Book findByBookName(String name);

    void deleteBook(String name);
}
