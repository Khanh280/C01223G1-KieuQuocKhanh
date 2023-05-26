package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("/")
    public String displayHome() {
        return "/home";
    }

    @GetMapping("/list")
    public String displayListBlog(Model model,@PageableDefault(value = 5) Pageable pageable) {
        Page<Blog> blogList = blogService.findAll(pageable);
        model.addAttribute("blogList", blogList);
        return "/list";
    }
//    @GetMapping("/blog")
//    public String listCustomers(Pageable pageable, Model model){
//        Page<Blog> customers = blogService.findAll(pageable);
//        model.addAttribute("customers", customers);
//        return "/list";
//    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("blog", new Blog());
        return "/create";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute("blog") Blog blog, Model model) {
        blogService.save(blog);
        return "/home";
    }

    @GetMapping("/update/{id}")
    public String updateInfo(@PathVariable("id") Long id, Model model) {
        Blog blog = blogService.getBlog(id);
        model.addAttribute("blog", blog);
        return "/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        return "redirect:/list";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Long id) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "/detail";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id, RedirectAttributes redirectAttributes) {
        boolean statusDelete = blogService.delete(id);
        redirectAttributes.addFlashAttribute("statusDelete", statusDelete);
        return "redirect:/list";
    }

    @GetMapping("/search")
    public String search(@RequestParam("title") String title, Model model) {
        List<Blog> blogList = blogService.searchBlog(title);
        model.addAttribute("blogList",blogList);
        model.addAttribute("title",title);
        return "/list";
    }
}
