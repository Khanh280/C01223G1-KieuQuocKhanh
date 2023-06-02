package com.example.blog.controller.rest_ful;

import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin/blog")
public class BlogRestController {
    @Autowired
    private IBlogService iBlogService;
    @GetMapping("")
    public ResponseEntity<List<Blog>> showListBlog(){
        return new ResponseEntity<>(iBlogService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Blog> detail(@PathVariable("id") Long id){
        return new ResponseEntity<>(iBlogService.findById(id),HttpStatus.OK);
    }
}
