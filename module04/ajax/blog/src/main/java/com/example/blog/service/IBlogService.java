package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface IBlogService {
    Page<Blog> getAllPage(Integer page);
    void save(Blog blog);
    Blog findById(Long id);
    boolean delete(Long id);
    Page<Blog> searchBlog(String title, Pageable pageable);
    Slice<Blog> searchBlogSlice(String title);
    Slice<Blog> findAll(Pageable pageable);
}
