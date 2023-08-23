package com.casestudy.happy_paws.controller;

import com.casestudy.happy_paws.dto.BookingServiceDTO;
import com.casestudy.happy_paws.dto.CustomerDTO;
import com.casestudy.happy_paws.model.*;
import com.casestudy.happy_paws.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/admin/booking-service")

public class BookingServiceController {
    @Autowired
    private EmailService emailService;
    @Autowired private IAccountService accountService;

    @Autowired private ICustomerService customerService;
    @Autowired
    private IBookingServiceService iBookingServiceService;

    @Autowired
    private IPetServiceService iPetServiceService;

    @Autowired
    private IBookingServiceServiceDetail iBookingServiceServiceDetail;

    @Autowired
    private ICustomerService iCustomerService;


    @GetMapping("/list")
    public String showPage(Model model, @RequestParam(value = "page", defaultValue = "0") Optional<Integer> page) {
        Pageable pageable = PageRequest.of(page.orElse(0), 5, Sort.by(Sort.Order.asc("bookingDate")));

        Page<BookingService> bookingServicePage1 = iBookingServiceService.findPage(pageable);
        List<BookingService> bookingServiceListToGetTotal = iBookingServiceService.findAll();
        for (int i = 0; i < bookingServiceListToGetTotal.size(); i++) {
            bookingServiceListToGetTotal.get(i).setTotal(iBookingServiceServiceDetail.getTotalByIdBooking(bookingServiceListToGetTotal.get(i).getBookingServiceId()));
            iBookingServiceService.save(bookingServiceListToGetTotal.get(i));
        }
//        Double revenue = 0.0;
//        for (int i = 0; i < iBookingServiceService.findAll().size(); i++) {
//            revenue = revenue + bookingServiceListToGetTotal.get(i).getTotal();
//        }


//        for (int i = 0; i < bookingServiceList.size(); i++) {
//            revenue = revenue + bookingServiceList.get(i).getTotal();
//        }
//        model.addAttribute("revenue", revenue);
        List<BookingServiceDTO> bookingServiceList = new ArrayList<>();
        for (BookingService b : bookingServicePage1) {
            BookingServiceDTO bookingServiceDTO = new BookingServiceDTO(b.getBookingServiceId(), b.getCustomer(), b.getBookingDate(), b.getBookingTime(), b.getCreateTime(), b.getUpdateTime(), iBookingServiceServiceDetail.getTotalByIdBooking(b.getBookingServiceId()));
            bookingServiceList.add(bookingServiceDTO);
        }
        Page<BookingServiceDTO> bookingServiceDTOPage = new PageImpl<>(bookingServiceList, pageable, bookingServicePage1.getTotalElements());
        model.addAttribute("bookingServicePage", bookingServiceDTOPage);
        model.addAttribute("search", false);


        return "pet-service/booking/list";
    }

    @GetMapping("/searchByDate")
    public String searchByDate(@RequestParam("searchDate") String searchDate, @RequestParam(value = "page", defaultValue = "0") Optional<Integer> page, Model model) {
        LocalDate date = LocalDate.parse(searchDate);
        Pageable pageable = PageRequest.of(page.orElse(0), 5, Sort.by(Sort.Order.asc("bookingDate")));
        List<BookingService> bookingServiceListToGetTotal = iBookingServiceService.searchByDateWithTotal(date);
        for (int i = 0; i < bookingServiceListToGetTotal.size(); i++) {
            bookingServiceListToGetTotal.get(i).setTotal(iBookingServiceServiceDetail.getTotalByIdBooking(bookingServiceListToGetTotal.get(i).getBookingServiceId()));
            iBookingServiceService.save(bookingServiceListToGetTotal.get(i));
        }
//        Double revenue = 0.0;
//        for (int i = 0; i < bookingServiceListToGetTotal.size(); i++) {
//            revenue = revenue + bookingServiceListToGetTotal.get(i).getTotal();
//        }
        Page<BookingService> bookingServicePage1 = iBookingServiceService.searchByDate(pageable, date);
        List<BookingServiceDTO> bookingServiceList = new ArrayList<>();
        for (BookingService b : bookingServicePage1) {
            BookingServiceDTO bookingServiceDTO = new BookingServiceDTO(b.getBookingServiceId(), b.getCustomer(), b.getBookingDate(), b.getBookingTime(), b.getCreateTime(), b.getUpdateTime(), iBookingServiceServiceDetail.getTotalByIdBooking(b.getBookingServiceId()));
            bookingServiceList.add(bookingServiceDTO);
        }


//        model.addAttribute("revenue", revenue);
        Page<BookingServiceDTO> bookingServiceDTOPage = new PageImpl<>(bookingServiceList, pageable, bookingServicePage1.getTotalElements());
        model.addAttribute("bookingServicePage", bookingServiceDTOPage);
        model.addAttribute("searchDate", searchDate);
        model.addAttribute("search", true);
        if (!bookingServiceDTOPage.hasContent()){
            model.addAttribute("notFound",true);
        }
        return "pet-service/booking/list";
    }


    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id")Long bookingServiceId , Model model){
        List<PetService>petServiceList = iPetServiceService.findByBookingServiceIdJoinWithBookingService(bookingServiceId);
        model.addAttribute("petServiceList",petServiceList);
        BookingService bookingService = iBookingServiceService.findBookingServiceById(bookingServiceId);
        Customer customer = iCustomerService.findById(bookingService.getCustomer().getCustomerId());
        model.addAttribute("customer",customer);
        model.addAttribute("bookingService",bookingService);

        model.addAttribute("total",iBookingServiceServiceDetail.getTotalByIdBooking(bookingServiceId));
        return "pet-service/booking/Home";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") Long id, RedirectAttributes redirectAttributes) {
        iBookingServiceService.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "Deleted Successfully");
        return "redirect:/api/admin/booking-service/list";
    }

    @GetMapping("/create")
    public String createView(Model model, @RequestParam("page") Optional<Integer> page) {
        Pageable pageable = PageRequest.of(page.orElse(0), 5, Sort.by(Sort.Order.desc("updateTime")));
        Page<Customer> customerPage = iBookingServiceService.findPageCustomer(pageable);
        model.addAttribute("customerList", customerPage);
        model.addAttribute("bookingService", new BookingService());
        model.addAttribute("search", false);

        return "pet-service/booking/select-customer-new";

    }


    @GetMapping("/create-customer")
    public String create(Model model) {
        model.addAttribute("customerDTO", new CustomerDTO());
        return "pet-service/booking/create-customer";
    }



    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("customerDTO") CustomerDTO customerDTO, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {

//        ,@RequestParam("confirm") String confirm
//        if(!confirm.equals(customerDTO.getAccountDTO().getPassword())){
//            return "/customers/create";
//        }

        try {

//       new CustomerDTO().validate(customerDTO,bindingResult);
            if (bindingResult.hasErrors()) {
                return "pet-service/booking/create-customer";
            }
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDTO, customer);
//            Account account = new Account(customerDTO.getAccountDTO().getUsername(), customerDTO.getAccountDTO().getPassword(), new Role(2, "CUSTOMER"));
//            accountService.save(account);

            boolean check = customerService.save(customer);
            if (!check) {
                model.addAttribute("mess", "Phone or email duplicated");
                return "pet-service/booking/create-customer";
            }
//            model.addAttribute("account", account);
//            redirectAttributes.addFlashAttribute("customerId", customer.getCustomerId());

        } catch (HttpServerErrorException.InternalServerError e) {
            return "/customers/500";
        }

        redirectAttributes.addFlashAttribute("mess", "Add New Successfully");

        return "redirect:/api/admin/booking-service/create";
    }
    @PostMapping("/search-customer")
    public String search(@RequestParam(value = "page ", defaultValue = "0") Optional<Integer> page, @RequestParam("name") String name
            , @RequestParam("phone") String phone, Model model) {
        Pageable pageable = PageRequest.of(page.orElse(0), 5, Sort.by(Sort.Order.desc("updateTime")));
        Page<Customer> customerList = customerService.findCustomer('%' + name + '%', '%' + phone + '%', pageable);
        model.addAttribute("customerList", customerList);
        model.addAttribute("name", name);
        model.addAttribute("phone", phone);
        model.addAttribute("bookingService", new BookingService());
        model.addAttribute("search" , true);
        if (!customerList.hasContent()){
            model.addAttribute("notFound",true);
        }
        return "pet-service/booking/select-customer-new";
    }






















    @GetMapping("/chooseService")
    public String createBooking(@RequestParam("customerId") Integer customerId, @RequestParam("bookingDate") String bookingDate, @RequestParam("bookingTime") String time, @RequestParam(value = "page", defaultValue = "0") Optional<Integer> page, Model model) {
        Customer customer = iBookingServiceService.findCustomerById(customerId);
        LocalDate date = LocalDate.parse(bookingDate);

        BookingService bookingService = new BookingService();
        bookingService = new BookingService(customer, date, time);
        iBookingServiceService.save(bookingService);
        model.addAttribute("bookingServiceDetail", new BookingServiceDetail());
        Pageable pageable = PageRequest.of(page.orElse(0), 5, Sort.by(Sort.Order.desc("updateTime")));
        Page<PetService> petServicePage = iPetServiceService.findPage(pageable);
        model.addAttribute("petServicePage", petServicePage);
        model.addAttribute("bookingService", bookingService);
        Boolean checked = true;
        model.addAttribute("checked", checked);

        return "pet-service/booking/select-service";
    }


    //    @GetMapping("/selectService/{customerId}")
//    public String selectService(@PathVariable("customerId")Integer customerId, Model model){
//        Customer customer = iBookingServiceService.findCustomerById(customerId);
//        BookingService bookingService = new BookingService();
//        bookingService.setCustomer(customer);
//        iBookingServiceService.save(bookingService);
//        model.addAttribute("bookingService",bookingService);
//        return "pet-service/booking/select-time";
//    }
    @PostMapping("/bookingServiceDetail/{bookingServiceId}")
    public String detail(@PathVariable("bookingServiceId") Long bookingServiceId, @RequestParam("petServiceId") Long petServiceId, RedirectAttributes redirectAttributes, Model model) {


        BookingService bookingService = iBookingServiceService.findBookingServiceById(bookingServiceId);
       List<BookingServiceDetail> bookingServiceDetailList = iBookingServiceServiceDetail.findByBookingServiceId(bookingServiceId);
        for (int i = 0; i < bookingServiceDetailList.size(); i++) {
            if (bookingServiceDetailList.get(i).getPetService().getPetServiceId().equals(petServiceId)){
                redirectAttributes.addFlashAttribute("mess",false);
                redirectAttributes.addFlashAttribute("bookingService", bookingService);
                return "redirect:/api/admin/booking-service/addMore";
            }
        }
        PetService petService = iPetServiceService.findById(petServiceId);

        Double price = petService.getPrice();

        BookingServiceDetail bookingServiceDetail = new BookingServiceDetail(price, petService, bookingService);

        iBookingServiceServiceDetail.save(bookingServiceDetail);

//        redirectAttributes.addFlashAttribute("customerId",bookingService.getCustomer().getCustomerId());

//        model.addAttribute("petServicePage", petServicePage);
        redirectAttributes.addFlashAttribute("bookingService", bookingService);
        redirectAttributes.addFlashAttribute("mess",true);

        return "redirect:/api/admin/booking-service/addMore";
    }
    @GetMapping("/addMore")
    public String addMore( @RequestParam(value = "page", defaultValue = "0") Optional<Integer> page, Model model){
        model.addAttribute("bookingServiceDetail", new BookingServiceDetail());
        Pageable pageable = PageRequest.of(page.orElse(0), 5, Sort.by(Sort.Order.desc("updateTime")));
        Page<PetService> petServicePage = iPetServiceService.findPage(pageable);
        model.addAttribute("petServicePage", petServicePage);
        model.addAttribute("mess", model.getAttribute("mess"));
//        model.addAttribute("error", model.getAttribute("error"));
//        model.addAttribute("bookingService", model.getAttribute("bookingService"));


        return "pet-service/booking/select-service";
    }




    @GetMapping(value = "/done" )
    public String editCustomer()
    {

        return "redirect:/api/admin/booking-service/list";
    }



}























