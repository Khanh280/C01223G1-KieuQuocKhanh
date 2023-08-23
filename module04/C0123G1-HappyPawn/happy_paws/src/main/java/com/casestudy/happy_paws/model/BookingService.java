package com.casestudy.happy_paws.model;

import com.sun.istack.NotNull;
import net.bytebuddy.asm.Advice;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
@Entity
@EntityListeners(AuditingEntityListener.class)
@SQLDelete(sql = "UPDATE booking_service SET is_delete = true WHERE booking_service_id=?")
@Where(clause = "is_delete=false")
public class BookingService implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingServiceId;
    @ManyToOne
    @JoinColumn
    private Customer customer;




    private LocalDate bookingDate;

    private String bookingTime;
    @Column(name = "createTime", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT now()")
    @CreationTimestamp
    private Date createTime;
    @Column(name = "updateTime", nullable = false, columnDefinition = "TIMESTAMP DEFAULT now()")
    @UpdateTimestamp
    private Date updateTime;

    private boolean isDelete = false;

    private Double total;

    public BookingService() {

    }

    public BookingService(Long bookingServiceId, Customer customer, LocalDate bookingDate, String bookingTime, Date createTime, Date updateTime, boolean isDelete, Double total) {
        this.bookingServiceId = bookingServiceId;
        this.customer = customer;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.isDelete = isDelete;
        this.total = total;
    }

    public BookingService(Customer customer, LocalDate bookingDate, String bookingTime, Double total) {
        this.customer = customer;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.total = total;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public BookingService(Customer customer, LocalDate bookingDate, String bookingTime) {
        this.customer = customer;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
    }

    public BookingService(Long bookingServiceId, Customer customer, LocalDate bookingDate, String bookingTime, Date createTime, Date updateTime, boolean isDelete) {
        this.bookingServiceId = bookingServiceId;
        this.customer = customer;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.isDelete = isDelete;
    }

    public BookingService(Long bookingServiceId, Customer customer, LocalDate bookingDate, String bookingTime) {
        this.bookingServiceId = bookingServiceId;
        this.customer = customer;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
    }

    public BookingService(Long bookingServiceId, Customer customer, LocalDate bookingDate, String bookingTime, Date createTime, Date updateTime) {
        this.bookingServiceId = bookingServiceId;
        this.customer = customer;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Long getBookingServiceId() {
        return bookingServiceId;
    }

    public void setBookingServiceId(Long bookingServiceId) {
        this.bookingServiceId = bookingServiceId;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (this.bookingDate.isAfter(LocalDate.now()) || this.bookingDate.equals(LocalDate.now())){
            errors.rejectValue("bookingDate","","An appointment can not be in the past or today");
        }
    }
}