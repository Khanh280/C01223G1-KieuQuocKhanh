package com.example.blog.service.impl;

import com.example.blog.model.Blog;
import com.example.blog.repository.IBlogRepository;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Page<Blog> getAllPage(Integer page) {
        return blogRepository.findAll(PageRequest.of(page,10));
    }

    @Override
    public void save(Blog blog) {
        this.blogRepository.save(blog);
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public boolean delete(Long id) {
        try {
            blogRepository.deleteById(id);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public Page<Blog> searchBlog(String title, Pageable pageable) {
        return blogRepository.searchBlogByTitle(title, pageable);
    }

    @Override
    public Slice<Blog> searchBlogSlice(String title) {
        return blogRepository.searchBlogByTitleSlice(title);
    }

    @Override
    public Slice<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }
}
