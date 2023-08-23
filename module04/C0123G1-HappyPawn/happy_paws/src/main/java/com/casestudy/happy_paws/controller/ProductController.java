package com.casestudy.happy_paws.controller;

import com.casestudy.happy_paws.dto.ProductDTO;
import com.casestudy.happy_paws.model.Product;
import com.casestudy.happy_paws.service.IProductService;
import com.casestudy.happy_paws.service.IProductTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/api/admin/product")
public class ProductController {
    @Autowired

    private IProductService productService;
    @Autowired
    private IProductTypeService productTypeService;

    @GetMapping("")
    public String showList(@RequestParam(value = "page", defaultValue = "0") Integer page, Model model) {
        Pageable pageable = PageRequest.of(page, 8,Sort.by("id").descending());
        model.addAttribute("productList", productService.findAll(pageable));
        model.addAttribute("pageList", true);
        model.addAttribute("productTypeList",productTypeService.findAll());
        return "product/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("productTypeList", productTypeService.findAll());
        model.addAttribute("productDTO", new ProductDTO());
        return "product/create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute("productDTO") ProductDTO productDTO, BindingResult bindingResult,RedirectAttributes redirectAttributes, Model model) {
        new ProductDTO().validate(productDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("productTypeList",productTypeService.findAll());
            return "product/create";
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        productService.save(product);
        redirectAttributes.addFlashAttribute("mess","Create is successfully!");
        return "redirect:/api/admin/product";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("productTypeList", productTypeService.findAll());
        model.addAttribute("productDTO", productService.findById(id));
        return "product/edit";
    }

    @PostMapping("/edit")
    public String edit(@Validated @ModelAttribute("productDTO") ProductDTO productDTO, BindingResult bindingResult,RedirectAttributes redirectAttributes) {
        new ProductDTO().validate(productDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "product/edit";
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        productService.save(product);
        redirectAttributes.addFlashAttribute("mess","Update is successfully!");
        return "redirect:/api/admin/product";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Long id,RedirectAttributes redirectAttributes) {
        productService.deleteById(id);
        redirectAttributes.addFlashAttribute("mess","Delete is successfully!");
        return "redirect:/api/admin/product";
    }
    @GetMapping("/search")
    public String search(@RequestParam("productType") String nameProductType,@RequestParam("name") String name, @RequestParam("origin") String origin, @RequestParam(value = "page",defaultValue = "0")Integer page,Model model ){
        Pageable pageable=PageRequest.of(page,8);
        Page<Product> productPage=productService.search("%"+name+"%","%"+origin+"%","%"+nameProductType+"%",pageable);
        if(productPage.isEmpty()){
            model.addAttribute("notFound",true);
        }
        model.addAttribute("productList",productPage);
        model.addAttribute("name",name);
        model.addAttribute("origin",origin);
        model.addAttribute("nameProductType",nameProductType);
        model.addAttribute("productTypeList",productTypeService.findAll());
        model.addAttribute("pageSearch",true);
        return "product/list";
    }
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id")Long id,Model model){
        model.addAttribute("product",productService.findById(id));
    return "product/detail";
    }
}