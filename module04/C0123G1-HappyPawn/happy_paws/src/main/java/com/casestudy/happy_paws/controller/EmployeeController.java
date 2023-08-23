package com.casestudy.happy_paws.controller;

import com.casestudy.happy_paws.dto.EmployeeDTO;
import com.casestudy.happy_paws.model.Account;
import com.casestudy.happy_paws.model.Employee;
import com.casestudy.happy_paws.model.Role;
import com.casestudy.happy_paws.service.IAccountService;
import com.casestudy.happy_paws.service.IEmployeeService;
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
//@RequestMapping("api/admin/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private IAccountService iAccountService;

    @GetMapping("/employee")
    public String display(Model model, @RequestParam(value = "page", defaultValue = "0") Integer page) {
        Pageable pageable = PageRequest.of(page, 5, Sort.by("dateCreate").descending());
        Page<Employee> list = iEmployeeService.getAll(pageable);
        model.addAttribute("employeeList", list);
        model.addAttribute("pageList",true);
        return "employee_view/employee_list";
    }

    @GetMapping("/create-employee")
    public String createEmployee(Model model) {
        model.addAttribute("employee", new EmployeeDTO());
        return "/employee_view/create_employee";
    }

    @PostMapping("/save-employee")
    public String saveEmployee(@Validated @ModelAttribute(value = "employee") EmployeeDTO employeeDTO, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("employee", employeeDTO);
            return "/employee_view/create_employee";
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDTO, employee);
            boolean check = true;
            check = iEmployeeService.checkEmployee(employee);
            if (!check) {
                model.addAttribute("result", "Email or phone or username is duplicated!!!");
                return "/employee_view/create_employee";
            }
            Account account = new Account(employee.getAccount().getUsername(), employee.getAccount().getPassword(), new Role(3, "EMPLOYEE"));
            account.setCode(11111);
            employee.setAccount(account);
            iAccountService.save(account);
            iEmployeeService.save(employee);
            redirectAttributes.addFlashAttribute("mess", true);
            return "redirect:/employee";
        }
    }

    @GetMapping("/delete-employee")
    public String deleteEmployee(@RequestParam("id") Long id, RedirectAttributes redirectAttributes) {
        boolean statusDelete = iEmployeeService.delete(id);
        redirectAttributes.addFlashAttribute("statusDelete", statusDelete);
        redirectAttributes.addFlashAttribute("pageList", true);
        return "redirect:/employee";
    }


    @GetMapping("/update-employee/{id}")
    public String getEmployeeById(@PathVariable Long id, Model model) {
        Employee employee = iEmployeeService.findById(id);
        model.addAttribute("employee", employee);
        return "employee_view/update_employee";
    }

    @PostMapping("/edit-employee")
    public String updateBlog(@Validated @ModelAttribute(value = "employee") EmployeeDTO employeeDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes ,Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("employee", employeeDTO);
            return "/employee_view/update_employee";
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDTO, employee);
            boolean check ;
            check = iEmployeeService.checkEditEmployee(employee);
            if(!check){
                model.addAttribute("result", "Email or phone or username is duplicated!!!");
                return "/employee_view/update_employee";
            }
            iEmployeeService.save(employee);
            redirectAttributes.addFlashAttribute("mess", true);
            return "redirect:/employee";
        }
    }

    @GetMapping("/search-employee")
    public String searchEmployee(@RequestParam("name") String name,
                                 @RequestParam("phone") String phone,
                                 @RequestParam(value = "page",defaultValue = "0")Integer page,Model model, Pageable pageable) {
        pageable = PageRequest.of(page, 5);
        Page<Employee> employees = iEmployeeService.findEmployee(name, phone, pageable);
        if(employees.isEmpty()){
            model.addAttribute("messSearch","There is no data for search !");
        }
        model.addAttribute("employeeList", employees);
        model.addAttribute("name", name);
        model.addAttribute("phone", phone);
        model.addAttribute("pageSearch",true);

        return "employee_view/employee_list";
    }
}
