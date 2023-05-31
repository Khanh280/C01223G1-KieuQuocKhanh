package com.borrow_books.repository;

import com.borrow_books.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IBookRepository extends JpaRepository<Book,Long> {
    @Query(value = "update book set quantity = quantity - 1 where id = :id",nativeQuery = true)
    @Modifying
    @Transactional
    void updateBorrow(@Param("id") Long id);
    @Query(value = "update book set quantity = quantity + 1 where id = :id",nativeQuery = true)
    @Modifying
    @Transactional
    void updateReturn(@Param("id") Long id);
}
