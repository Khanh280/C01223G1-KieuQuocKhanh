package com.example.blog.service;

import com.example.blog.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    void save(Blog blog);
    Blog getBlog(Long id);
    Blog findById(Long id);
    boolean delete(Long id);
    List<Blog> searchBlog(String title);
}
