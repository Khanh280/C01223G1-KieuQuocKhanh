package com.example.blog.model;

import javax.persistence.*;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    private String categoryName;
    @Column(name = "is_delete", columnDefinition = "BIT DEFAUTL 0")
    private boolean isDelete;

    public Category() {
    }

    public Category(Long categoryId, String categoryName, boolean isDelete) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.isDelete = isDelete;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public boolean getDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
