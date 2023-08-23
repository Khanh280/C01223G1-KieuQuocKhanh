package com.casestudy.happy_paws.controller;

import com.casestudy.happy_paws.dto.PetServiceDTO;
import com.casestudy.happy_paws.model.PetService;
import com.casestudy.happy_paws.service.IPetServiceService;
import com.casestudy.happy_paws.service.impl.BookingEmailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.Optional;

@Controller
@RequestMapping("/api/admin/pet-service")
public class PetServiceController {
    @Autowired
    private IPetServiceService iPetServiceService;

    @Autowired
    private BookingEmailService bookingEmailService;

    @GetMapping("/list")
    public String ShowPage(Model model, @RequestParam(value = "page", defaultValue = "0") Optional<Integer> page) {
        Pageable pageable = PageRequest.of(page.orElse(0), 5, Sort.by(Sort.Order.desc("updateTime")));
        Page<PetService> petServicePage = iPetServiceService.findPage(pageable);
        model.addAttribute("petServicePage", petServicePage);
        return "pet-service/service/pet-service-list-moi";
    }

    @GetMapping("/search")
    public String search(@RequestParam("search") String search,@RequestParam(value = "page", defaultValue = "0") Optional<Integer> page, Model model){
        Pageable pageable = PageRequest.of(page.orElse(0),5,Sort.by(Sort.Order.desc("updateTime")));

        Page<PetService> petServicePage = iPetServiceService.searchPage(search,pageable);
        model.addAttribute("petServicePage",petServicePage);
        model.addAttribute("search",search);
        if (!petServicePage.hasContent()){
            model.addAttribute("notFound",true);
        }
        return "pet-service/service/pet-service-list-moi";
    }


    @GetMapping("/search/{search}/{page}")
    public String searchPage(@PathVariable("search") String search,@PathVariable(value = "page") Optional<Integer> page, Model model){
        Pageable pageable = PageRequest.of(page.orElse(0),5,Sort.by(Sort.Order.desc("updateTime")));

        Page<PetService> petServicePage = iPetServiceService.searchPage(search,pageable);
        model.addAttribute("petServicePage",petServicePage);
        model.addAttribute("search",search);
        if (!petServicePage.hasContent()){
            model.addAttribute("notFound",true);
        }
        return "pet-service/service/pet-service-list-moi";
    }





    @GetMapping("/create")
    public String createView(@ModelAttribute("petServiceDTO") PetServiceDTO petServiceDTO) {
        return "pet-service/service/create-moi";
    }

    @PostMapping("/create")
    public String saveService(@Validated @ModelAttribute("petServiceDTO") PetServiceDTO petServiceDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "pet-service/service/create-moi";
        }

        PetService petService = new PetService();
        BeanUtils.copyProperties(petServiceDTO, petService);
        iPetServiceService.save(petService);
        redirectAttributes.addFlashAttribute("message", "Added Successfully");
        return "redirect:/api/admin/pet-service/list";
    }

    @GetMapping("/edit/{id}")
    public String editView(@PathVariable("id") Long id, Model model) {
        PetService petService = iPetServiceService.findById(id);
        PetServiceDTO petServiceDTO = new PetServiceDTO();
        BeanUtils.copyProperties(petService, petServiceDTO);
        model.addAttribute("petServiceDTO", petServiceDTO);
        return "pet-service/service/update-moi";
    }

    @PostMapping("/edit")
    public String edit(@Validated @ModelAttribute("petServiceDTO") PetServiceDTO petServiceDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            return "pet-service/service/update-moi";
        }
        PetService petService = new PetService();
        BeanUtils.copyProperties(petServiceDTO, petService);
        iPetServiceService.save(petService);
        redirectAttributes.addFlashAttribute("message", "Updated Successfully");
        return "redirect:/api/admin/pet-service/list";

    }

    @PostMapping("/delete")
    public String deleteById(@RequestParam("id") Long id, RedirectAttributes redirectAttributes) {
        iPetServiceService.deleteById(id);

        redirectAttributes.addFlashAttribute("message", "Deleted Successfully");
        return "redirect:/api/admin/pet-service/list";

    }

    @GetMapping("/detail/{id}")
    public String detailService(@PathVariable("id") Long id, Model model) {
        PetService petService = new PetService();
        petService = iPetServiceService.findById(id);
        model.addAttribute("petService", petService);


//        send test email
   /*     String to = "khavyy98@gmail.com";
        String subject = "Hello Kha Vy";
        String body = "Hello Kha  \n\n"
                +"This is a message just for you who is invited to our wedding on July 1st 2023, at 6pm. "
                + "Your appearance will be our pleasure, so we hope to see you soon  \n"
                + "We hope you're having a great day!\n\n"
                + "Best regards,\n"
                + "The Spring Boot Team";*/

//        bookingEmailService.sendEmail(to,subject,body);
        return "pet-service/service/detail";
    }


}
