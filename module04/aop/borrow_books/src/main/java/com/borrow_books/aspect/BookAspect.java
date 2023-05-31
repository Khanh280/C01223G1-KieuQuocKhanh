package com.borrow_books.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Aspect
@Component
public class BookAspect {
    private static int count=0;
    @AfterReturning(value = "execution(* com.borrow_books.controller.BorrowBookController.returnBook(..))",returning = "result")
    public void logReturn(JoinPoint joinPoint,Object result){
        File file = new File("D:\\Codegym\\bai_tap\\module04\\aop\\borrow_books\\src\\main\\java\\com\\borrow_books\\log\\action_book.csv");
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try{
            fileWriter = new FileWriter(file,true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(joinPoint.getSignature().getName());
            bufferedWriter.newLine();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @AfterReturning(value = "execution(* com.borrow_books.controller.BorrowBookController.borrowBook(..))" , returning = "result")
    public void logBorrow(JoinPoint joinPoint,Object result){
        File file = new File("D:\\Codegym\\bai_tap\\module04\\aop\\borrow_books\\src\\main\\java\\com\\borrow_books\\log\\action_book.csv");
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try{
            fileWriter = new FileWriter(file,true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(joinPoint.getSignature().getName());
            bufferedWriter.newLine();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @After(value = "execution(* com.borrow_books.controller.BorrowBookController.*(..))")
    public void logUserVisit(JoinPoint joinPoint){
        File file = new File("D:\\Codegym\\bai_tap\\module04\\aop\\borrow_books\\src\\main\\java\\com\\borrow_books\\log\\user_visit.csv");
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        count++;
        try{
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(count);
            bufferedWriter.newLine();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
