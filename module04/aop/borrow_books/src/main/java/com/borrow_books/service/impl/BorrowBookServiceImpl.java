package com.borrow_books.service.impl;

import com.borrow_books.model.Book;
import com.borrow_books.model.BorrowBook;
import com.borrow_books.repository.IBorrowBookRepository;
import com.borrow_books.service.IBookService;
import com.borrow_books.service.IBorrowBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowBookServiceImpl implements IBorrowBookService {
    @Autowired
    private IBorrowBookRepository iBorrowBookRepository;
    @Autowired
    private IBookService iBookService;

    @Override
    public List<BorrowBook> findAll() {
        return iBorrowBookRepository.findAll();
    }

    @Override
    public boolean saveBorrowBook(BorrowBook borrowBook) {
        iBorrowBookRepository.save(borrowBook);
        return true;
    }

    @Override
    public BorrowBook returnBook(String codeBorrowBook) {
        List<BorrowBook> borrowBooks = iBorrowBookRepository.findAllBorrowBook();
        for (int i = 0; i < borrowBooks.size(); i++) {
            if(borrowBooks.get(i).getCodeBorrowBook().equals(codeBorrowBook)){
                iBorrowBookRepository.upadteBorrowBook(codeBorrowBook);
                return borrowBooks.get(i);
            }
        }
        return null;
    }

    @Override
    public String randomCodeborrow() {

        String codeBorrowBook;
        boolean checkCodeBorrowBook;
        do {
            checkCodeBorrowBook = true;
            codeBorrowBook = String.valueOf(Math.round(Math.random() * (99999 - 10000) + 10000));
            List<BorrowBook> borrowBooks = findAll();
            for (int i = 0; i < borrowBooks.size(); i++) {
                if (borrowBooks.get(i).getCodeBorrowBook().equals(codeBorrowBook)) {
                    checkCodeBorrowBook = false;
                    break;
                }
            }
        } while (!checkCodeBorrowBook);
        return codeBorrowBook;
    }
}
