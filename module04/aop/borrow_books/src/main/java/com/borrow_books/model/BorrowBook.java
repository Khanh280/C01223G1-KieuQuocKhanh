package com.borrow_books.model;

import javax.persistence.*;

@Entity
public class BorrowBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn
    private Book book;
    private String codeBorrowBook;
    private boolean status;

    public BorrowBook() {
    }

    public BorrowBook(Book book, String codeBorrowBook, boolean status) {
        this.book = book;
        this.codeBorrowBook = codeBorrowBook;
        this.status = status;
    }

    public BorrowBook(Long id, Book book, String codeBorrowBook, boolean status) {
        this.id = id;
        this.book = book;
        this.codeBorrowBook = codeBorrowBook;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getCodeBorrowBook() {
        return codeBorrowBook;
    }

    public void setCodeBorrowBook(String codeBorrowBook) {
        this.codeBorrowBook = codeBorrowBook;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
