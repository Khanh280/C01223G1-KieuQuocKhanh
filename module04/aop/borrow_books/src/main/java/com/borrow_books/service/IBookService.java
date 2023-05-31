package com.borrow_books.service;

import com.borrow_books.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
    Book findBookById(Long id);
    void updateBorrow(Long id);
    void updateReturn(Long id);
}
