package com.borrow_books.repository;

import com.borrow_books.model.BorrowBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IBorrowBookRepository extends JpaRepository<BorrowBook,Long> {
    @Query(value = "update BorrowBook set status = true where codeBorrowBook = :codeBorrowBook")
    @Modifying
    @Transactional
    void upadteBorrowBook(@Param("codeBorrowBook") String codeBorrowBook);
    @Query(value = "select bb from BorrowBook bb where bb.status = false")
    List<BorrowBook> findAllBorrowBook();
}
