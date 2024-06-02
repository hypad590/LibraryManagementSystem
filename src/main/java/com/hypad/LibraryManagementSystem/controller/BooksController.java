package com.hypad.LibraryManagementSystem.controller;

import com.hypad.LibraryManagementSystem.model.Book;
import com.hypad.LibraryManagementSystem.service.BooksService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class BooksController {
    private final BooksService booksService;

    @GetMapping
    public List<Book> findAllBooks(){
        return booksService.findAllBooks();
    }

    @GetMapping("/book/{name}")
    public Book findBook(@PathVariable String name){
        return booksService.findByBookName(name);
    }

    @PostMapping("/addBook")
    public String addBook(@RequestBody Book book){
        booksService.addBook(book);
        return "Book: " + book.getName() + " with id: "+ book.getId()+" added successfully";
    }

    @PutMapping("/updateBookInfo")
    public Book updateBook(@RequestBody Book book){
        return booksService.updateBook(book);
    }

    @DeleteMapping("/deleteBook/{name}")
    public void deleteBook(@PathVariable String name){
        booksService.deleteBook(name);
    }
}
