package com.bookstore.service;

import com.bookstore.entity.Book;
import com.bookstore.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    // Внедрение зависимостей через конструктор
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAllBooks(String sortBy) {
        if ("author".equals(sortBy)) {
            return bookRepository.findAllByOrderByAuthorAsc();
        } else if ("year".equals(sortBy)) {
            return bookRepository.findAllByOrderByPublicationYearAsc();
        } else if ("category".equals(sortBy)) {
            return bookRepository.findAllByOrderByCategoryAsc();
        }
        return bookRepository.findAll();
    }

    public Book findBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    // Метод для админа
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }
}
