package com.example.blog.restful;

import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin/blog")
@CrossOrigin("*")
public class BlogRestController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<Slice<Blog>> showList(@RequestParam(value = "page",defaultValue = "0") Integer page){
        Pageable pageable = PageRequest.of(page,5, Sort.by("id"));
        Slice<Blog> blogSlice = blogService.findAll(pageable);
        return new ResponseEntity<>(blogSlice,HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Slice<Blog>> search(@RequestParam("title") String title, Model model) {
        Slice<Blog> blogSlice = blogService.searchBlogSlice(title);
        return new ResponseEntity<>(blogSlice, HttpStatus.OK);
    }
}
