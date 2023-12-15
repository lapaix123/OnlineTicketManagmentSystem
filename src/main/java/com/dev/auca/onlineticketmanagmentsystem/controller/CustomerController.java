package com.dev.auca.onlineticketmanagmentsystem.controller;

import com.dev.auca.onlineticketmanagmentsystem.model.Admin;
import com.dev.auca.onlineticketmanagmentsystem.model.Customer;
import com.dev.auca.onlineticketmanagmentsystem.service.CustomerService;
import com.dev.auca.onlineticketmanagmentsystem.service.EmailService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private EmailService emailService;
    @GetMapping("/customer")
    public String getCustomer(Model model,HttpSession session) {
        Admin authanticatedAdmin=(Admin) session.getAttribute("adminAuthenticated");
        if(authanticatedAdmin != null) {
            model.addAttribute("adminAuthenticated", authanticatedAdmin);
            Customer customer = new Customer();
            List<Customer> customers= customerService.allCustomers();
            model.addAttribute("customers",customers);
            model.addAttribute("customer",customer);
            return "customer";
        }else{
            return "adminLogin";
        }

    }
    @GetMapping("/customerForm")
    public String CustomerForm(Model model,HttpSession session){
        Admin authanticatedAdmin=(Admin) session.getAttribute("adminAuthenticated");
        if(authanticatedAdmin != null) {
            model.addAttribute("adminAuthenticated", authanticatedAdmin);
            Customer customer = new Customer();
            model.addAttribute("customer",customer);
            return "customerForm";
        }else{
            return "adminLogin";
        }

    }
    @GetMapping("/deleteCustomer/{customerId}")
    public String deleteCustomer(@PathVariable Integer customerId,Model model){
       customerService.deleteCustomer(customerId);
        return "redirect:/customer";
    }
    @GetMapping("/editCustomer/{customerId}")
    public String editCustomer(@PathVariable Integer customerId,Model model,HttpSession session){
        Admin authanticatedAdmin=(Admin) session.getAttribute("adminAuthenticated");
        if(authanticatedAdmin != null) {
            model.addAttribute("adminAuthenticated", authanticatedAdmin);
            Customer customer = customerService.findById(customerId);
            model.addAttribute("customer", customer);
            return "customerForm";
        }else{
            return "adminLogin";
        }

    }
@PostMapping("/newCustomer")
    public String newCustomer(Customer customer,Model model){
        Customer newCustomer = customerService.newCustomer(customer);
       emailService.sendEmail(newCustomer);
        return "redirect:/customer";
    }

    @PostMapping("/newCustomer/customer")
    public String newCustomerFromIndex(Customer customer,Model model){
        Customer newCustomer = customerService.newCustomer(customer);
        model.addAttribute("customer", new Customer()); // You might need to create a new instance for the login form
        return "redirect:/loginPage";

    }

    @PostMapping("/login")
    public String customerLogin(@RequestParam String email, @RequestParam String password, Model model, HttpSession session) {
        Customer customer = customerService.login(email, password);
        if (customer == null) {
            model.addAttribute("errorMessage", "wrong Username or password");
            return "login";
        }else{
            session.setAttribute("authenticatedCustomer",customer);
            return "redirect:/customerDash";
        }

    }



}
