package com.borrow_books.controller;

import com.borrow_books.model.Book;
import com.borrow_books.model.BorrowBook;

import com.borrow_books.service.IBookService;
import com.borrow_books.service.IBorrowBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
public class BorrowBookController {
    @Autowired
    private IBookService iBookService;
    @Autowired
    private IBorrowBookService iBorrowBookService;

    @GetMapping("/")
    public String displayList(Model model) {
        List<Book> bookList = iBookService.findAll();
        model.addAttribute("bookList", bookList);
        return "/home";
    }

    @GetMapping("/borrow")
    public String borrowBook(@RequestParam(value = "id", defaultValue = "0") Long id, RedirectAttributes redirectAttributes) {
        if (id == 0) {
            throw new RuntimeException("");
        }
        String codeBorrowBook = iBorrowBookService.randomCodeborrow();
        Book book = iBookService.findBookById(id);
        BorrowBook borrowBook = new BorrowBook(book, codeBorrowBook, false);
        boolean statusBorrowBook = iBorrowBookService.saveBorrowBook(borrowBook);
        iBookService.updateBorrow(id);
        return "redirect:/";
    }

    @GetMapping("return-book")
    public String returnBookInfo(Model model) {
        model.addAttribute("borrowBookList", iBorrowBookService.findAll());
        return "return_book";
    }

    @PostMapping("return-book")
    public String returnBook(@RequestParam("codeBorrowBook") String codeBorrowBook, RedirectAttributes redirectAttributes) {
        BorrowBook borrowBook = iBorrowBookService.returnBook(codeBorrowBook);
        if (borrowBook != null) {
            iBookService.updateReturn(borrowBook.getBook().getId());
            redirectAttributes.addFlashAttribute("statusReturnBook", true);
            return "redirect:/return-book";
        } else {
            throw new RuntimeException("");
        }
    }

    @ExceptionHandler(Exception.class)
    public String exception() {
        return "/404";
    }
}
