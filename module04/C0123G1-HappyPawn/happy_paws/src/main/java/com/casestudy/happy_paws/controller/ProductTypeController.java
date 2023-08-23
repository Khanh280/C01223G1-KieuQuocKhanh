package com.casestudy.happy_paws.controller;

import com.casestudy.happy_paws.dto.ProductTypeDTO;
import com.casestudy.happy_paws.model.ProductType;
import com.casestudy.happy_paws.service.IProductTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("api/admin/product-type")
public class ProductTypeController {
    @Autowired
    private IProductTypeService productTypeService;

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("productTypeList", productTypeService.findAll());
        return "product_type/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("productTypeDTO", new ProductTypeDTO());
        return "product_type/create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute("productTypeDTO") ProductTypeDTO productTypeDTO, BindingResult bindingResult,RedirectAttributes redirectAttributes) {
        new ProductTypeDTO().validate(productTypeDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "product_type/create";
        }
        ProductType productType = new ProductType();
        BeanUtils.copyProperties(productTypeDTO, productType);
        productTypeService.save(productType);
        redirectAttributes.addFlashAttribute("mess","Create is successfully!");
        return "redirect:/api/admin/product-type";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        productTypeService.deleteById(id);
        redirectAttributes.addFlashAttribute("mess","Delete is successfully!");
        return "redirect:/api/admin/product-type";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("productTypeDTO", productTypeService.findById(id));
        return "product_type/edit";
    }

    @PostMapping("/edit")
    public String edit(@Validated @ModelAttribute("productTypeDTO") ProductTypeDTO productTypeDTO, BindingResult bindingResult,RedirectAttributes redirectAttributes) {
        new ProductTypeDTO().validate(productTypeDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "product_type/edit";
        }
        ProductType productType = new ProductType();
        BeanUtils.copyProperties(productTypeDTO, productType);
        productTypeService.save(productType);
        redirectAttributes.addFlashAttribute("mess","Update is successfully!");
        return "redirect:/api/admin/product-type";
    }
}
