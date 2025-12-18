package com.bookstore.controller;

import com.bookstore.entity.Book;
import com.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')") // Требует роли ADMIN для доступа ко всему контроллеру
public class AdminController {

    @Autowired
    private BookService bookService;

    @GetMapping("/dashboard")
    public String adminDashboard(Model model) {
        model.addAttribute("books", bookService.findAllBooks(null));
        return "admin/dashboard"; // Шаблон панели администратора
    }

    @GetMapping("/books/new")
    public String createBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "admin/manage-books";
    }

    @PostMapping("/books/save")
    public String saveBook(@ModelAttribute Book book) {
        bookService.saveBook(book);
        return "redirect:/admin/dashboard";
    }

    // Добавьте методы для редактирования, удаления и управления статусами
}
