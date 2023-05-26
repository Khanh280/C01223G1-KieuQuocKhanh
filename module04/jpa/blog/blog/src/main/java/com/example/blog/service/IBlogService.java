package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);
    void save(Blog blog);
    Blog getBlog(Long id);
    Blog findById(Long id);
    boolean delete(Long id);
    List<Blog> searchBlog(String title);
}
