package com.borrow_books.service;

import com.borrow_books.model.Book;
import com.borrow_books.model.BorrowBook;

import java.util.List;

public interface IBorrowBookService {
    List<BorrowBook> findAll();
    boolean saveBorrowBook(BorrowBook borrowBook);
    BorrowBook returnBook(String codeBorrowBook);
    String randomCodeborrow();
}
