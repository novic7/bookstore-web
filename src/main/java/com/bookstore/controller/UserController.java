package com.bookstore.controller;

import com.bookstore.entity.Book;
import com.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private BookService bookService;

    @GetMapping({"/", "/index", "/books"})
    public String listBooks(@RequestParam(value = "sortBy", required = false) String sortBy, Model model) {
        List<Book> books = bookService.findAllBooks(sortBy);
        model.addAttribute("books", books);
        // Возвращает шаблон src/main/resources/templates/user/book-list.html
        return "user/book-list";
    }

    // Добавьте @GetMapping("/book-details") и @PostMapping("/rent") для логики покупки/аренды
}
