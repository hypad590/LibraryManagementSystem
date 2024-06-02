package com.hypad.LibraryManagementSystem.repository;

import com.hypad.LibraryManagementSystem.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class InMemBookRepository {
    private final List<Book> bookList = new ArrayList<>();

    public List<Book> findAllBooks(){
        return bookList;
    }

    public Book addBook(Book book){
        bookList.add(book);
        return book;
    }

    public Book updateBook(Book book){
        if (book == null || book.getName() == null) {
            return null;
        }
        var bookIndex = IntStream.range(0,
                bookList.size())
                .filter(index -> bookList.get(index).getName().equals(book.getName()))
                    .findFirst()
                .orElse(-1);
        if(bookIndex > -1){
            bookList.add(bookIndex, book);
            return book;
        }
        else {
            return null;
        }
    }
    public Book findByBookName(String name){
        return bookList
                .stream()
                    .filter(el -> el.getName().equals(name))
                .findFirst().orElse(null);
    }
    public void deleteBook(String name){
        var book = findByBookName(name);
        if(book != null){
            bookList.remove(book);
        }
    }
}
