package com.example.blog.controller;

import com.example.blog.model.Category;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/")
    public String displayCategory(Model model) {
        model.addAttribute("categoryList", categoryService.findAll());
        return "/category_manager";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        categoryService.deleteCategory(id);
        return "redirect:/category/";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("category", new Category());
        return "/create_category";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("category") Category category) {
        categoryService.saveCategory(category);
        return "redirect:/category/";
    }

    @GetMapping("/update/{categoryId}")
    public String updateInfo(@PathVariable("categoryId") Long categoryId, Model model) {
        model.addAttribute("category", categoryService.findById(categoryId));
        return "update_category";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute("category") Category category) {
        categoryService.saveCategory(category);
        return "redirect:/category/";
    }
}
