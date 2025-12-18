package com.bookstore.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String category;
    private Integer publicationYear;
    private Double priceBuy;
    private Double priceRent2Weeks;
    private Double priceRent1Month;
    private Double priceRent3Months;
    private String status; // "AVAILABLE", "RENTED"
    private Integer availability; // Количество в наличии

    // --- Геттеры и Сеттеры ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    public Double getPriceBuy() {
        return priceBuy;
    }

    public void setPriceBuy(Double priceBuy) {
        this.priceBuy = priceBuy;
    }

    public Double getPriceRent2Weeks() {
        return priceRent2Weeks;
    }

    public void setPriceRent2Weeks(Double priceRent2Weeks) {
        this.priceRent2Weeks = priceRent2Weeks;
    }

    public Double getPriceRent1Month() {
        return priceRent1Month;
    }

    public void setPriceRent1Month(Double priceRent1Month) {
        this.priceRent1Month = priceRent1Month;
    }

    public Double getPriceRent3Months() {
        return priceRent3Months;
    }

    public void setPriceRent3Months(Double priceRent3Months) {
        this.priceRent3Months = priceRent3Months;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getAvailability() {
        return availability;
    }

    public void setAvailability(Integer availability) {
        this.availability = availability;
    }
}
