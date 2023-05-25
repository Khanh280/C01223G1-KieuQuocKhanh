package com.example.blog.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
//@EntityListeners(AuditingEntityListener.class)
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(name = "content", columnDefinition = "text")
    private String content;
    @NonNull
    private String writer;
    @Column(name = "dateCreate", nullable = false,updatable = false, columnDefinition = "TIMESTAMP DEFAULT now()")
    @CreationTimestamp
    private LocalDateTime dateCreate;
    @Column(name = "dateUpdate", nullable = false, columnDefinition = "TIMESTAMP DEFAULT now()")
    @UpdateTimestamp
    private LocalDateTime dateUpdate;

    public Blog() {
    }

    public Blog(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

    public Blog(Long id, String title, String content, String writer,LocalDateTime dateCreate, LocalDateTime dateUpdate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.dateCreate = dateCreate;
        this.dateUpdate = dateUpdate;
    }

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public LocalDateTime getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDateTime dateCreate) {
        this.dateCreate = dateCreate;
    }

    public LocalDateTime getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(LocalDateTime dateUpdate) {
        this.dateUpdate = dateUpdate;
    }
}
