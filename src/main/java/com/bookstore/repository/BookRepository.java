package com.bookstore.repository;

import com.bookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    // Пользовательские методы для сортировки/фильтрации
    List<Book> findAllByOrderByCategoryAsc();
    List<Book> findAllByOrderByAuthorAsc();
    List<Book> findAllByOrderByPublicationYearAsc();
    List<Book> findByCategory(String category);
}
