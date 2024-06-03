package com.hypad.LibraryManagementSystem.controller;

import com.hypad.LibraryManagementSystem.model.Book;
import com.hypad.LibraryManagementSystem.service.BooksService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1")
@AllArgsConstructor
public class BooksController {
    private final BooksService booksService;

    //books.html
    @GetMapping
    public String findAllBooks(Model model){
        model.addAttribute("books",booksService.findAllBooks());
        return "books";
    }

    //todo
    @GetMapping("/book/{name}")
    public Book findBook(@PathVariable String name){
        return booksService.findByBookName(name);
    }

    //method post action /addBook in addBook.html
    @PostMapping("/addBook")
    public String addBook(@RequestBody Book book){
        if(book != null){
            booksService.addBook(book);
            System.out.println("Book: " + book.getName() + " with id: "+ book.getId()+" added successfully");
        }
        return "addBook";
    }
    @GetMapping("/addBook")
    public String addBook(){
        return "addBook";
    }

    @PutMapping("/updateBookInfo")
    public String updateBook(@RequestBody Book book, Model model){
        booksService.updateBook(book);
        model.addAttribute("book",book);
        return "redirect:/api/v1";
    }


    //method put action /updateBookInfo in updateBook.html
    @GetMapping("/updateBook")
    public String updateBook(){
        return "updateBook";
    }

    @DeleteMapping("/deleteBook/{name}")
    public void deleteBook(@PathVariable String name){
        booksService.deleteBook(name);
    }

    //method delete action /deleteBook/{name} in deleteBook.html
    @GetMapping("/deleteBook")
    public String deleteBook(){
        return "deleteBook";
    }
}
