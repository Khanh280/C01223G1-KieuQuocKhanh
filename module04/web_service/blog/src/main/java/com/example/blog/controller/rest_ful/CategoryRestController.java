package com.example.blog.controller.rest_ful;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin/category")
public class CategoryRestController {
    @Autowired
    private ICategoryService iCategoryService;
    @GetMapping("")
    public ResponseEntity<List<Category>> showCategoryList(){
        return new ResponseEntity<>(iCategoryService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{name}")
    public ResponseEntity<List<Blog>> showBlogInCategory(@PathVariable("name") String name){
        return new ResponseEntity<>(iCategoryService.findBlogCategoryByName(name),HttpStatus.OK);
    }
}
