package com.casestudy.happy_paws.controller;

import com.casestudy.happy_paws.model.*;
import com.casestudy.happy_paws.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/booking")
public class HomeBookingController {
    @Autowired
    private EmailService emailService;
    @Autowired
    private IBookingServiceServiceDetail iBookingServiceServiceDetail;

    @Autowired
    private IAccountService iAccountService;
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private IBookingServiceService iBookingServiceService;
    @Autowired
    private IPetServiceService iPetServiceService;
    @Autowired
    private IProductService iProductService;
    @Autowired
    private IProductTypeService iProductTypeService;


    @GetMapping("/reservation")
    public String homeBooking( Model model) {

//        model.addAttribute("bookingService",new BookingService());
//
        return "happy_paws/booking-page-new";
    }


    @PostMapping("/booking-choose-service")
    public String chooseService(Model model,@RequestParam("username") String username,
            @RequestParam("bookingDate") String bookingDate,
            @RequestParam("bookingTime") String bookingTime) {
        List<Account> accountList = iAccountService.findAll();

        Customer customer = new Customer();
        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).getUsername().equals(username)) {
                customer = iCustomerService.findCustomerByUserName(username);
                break;
            }
        }
        model.addAttribute("customerId", customer.getCustomerId());

        BookingService bookingService = new BookingService(customer, LocalDate.parse(bookingDate),bookingTime);
        iBookingServiceService.save(bookingService);
        List<PetService> petServiceList = iPetServiceService.findAll();

        model.addAttribute("petServiceList", petServiceList);
        model.addAttribute("bookingServiceId", bookingService.getBookingServiceId());


        return "happy_paws/select-service-new";
    }


    @GetMapping("/add")
    public String add(Model model, RedirectAttributes redirectAttributes,
                      @RequestParam("petServiceId")Long petServiceId ,
                      @RequestParam("bookingServiceId")Long bookingServiceId ){
        BookingService bookingService = iBookingServiceService.findBookingServiceById(bookingServiceId);
        List<BookingServiceDetail> bookingServiceDetailList = iBookingServiceServiceDetail.findByBookingServiceId(bookingServiceId);
        for (int i = 0; i < bookingServiceDetailList.size(); i++) {
            if (bookingServiceDetailList.get(i).getPetService().getPetServiceId().equals(petServiceId)){
                redirectAttributes.addFlashAttribute("mess",false);
                redirectAttributes.addFlashAttribute("bookingServiceId", bookingService.getBookingServiceId());
                return "redirect:/booking/addMore";
            }
        }
        PetService petService = iPetServiceService.findById(petServiceId);

        Double price = petService.getPrice();

        BookingServiceDetail bookingServiceDetail = new BookingServiceDetail(price, petService, bookingService);

        iBookingServiceServiceDetail.save(bookingServiceDetail);
        double total = iBookingServiceServiceDetail.getTotalByIdBooking(bookingServiceId);
        bookingService.setTotal(total);

//        redirectAttributes.addFlashAttribute("customerId",bookingService.getCustomer().getCustomerId());

//        model.addAttribute("petServicePage", petServicePage);
        redirectAttributes.addFlashAttribute("bookingServiceId", bookingService.getBookingServiceId());
        redirectAttributes.addFlashAttribute("mess",true);
        return "redirect:/booking/addMore";
    }
    @GetMapping("/addMore")
    public String addMore(Model model){
        model.addAttribute("bookingServiceDetail", new BookingServiceDetail());
        List<PetService> petServiceList = iPetServiceService.findAll();
        model.addAttribute("petServiceList", petServiceList);
        model.addAttribute("mess", model.getAttribute("mess"));
        model.addAttribute("bookingServiceId", model.getAttribute("bookingServiceId"));



        return "happy_paws/select-service-new";
    }


    @GetMapping("/done")
    public String done(@RequestParam(value = "page",defaultValue = "0")Integer page, Model model){


        Pageable pageable = PageRequest.of(page,100);
        model.addAttribute("productPage",iProductService.findAll(pageable));
        model.addAttribute("productTypeList",iProductTypeService.findAll());
        model.addAttribute("petServiceList",iPetServiceService.findPage(PageRequest.of(0,6)));
        return "/happy_paws/index";
    }

}
