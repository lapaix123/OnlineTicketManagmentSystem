package com.dev.auca.onlineticketmanagmentsystem.controller;

import com.dev.auca.onlineticketmanagmentsystem.model.Customer;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @GetMapping("/loginPage")
public String loginPage(Model model) {
    return "login";
}

    @GetMapping("/signupPage")
    public String signUpPage(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "signupPage";
    }
    @GetMapping("/customerDash")
    public String getCustomerPage(HttpSession session,Model model){
        Customer authanticatedCustomer = (Customer) session.getAttribute("authenticatedCustomer");
        if(authanticatedCustomer != null){
            model.addAttribute("authenticatedCustomer",authanticatedCustomer);
            return "customerDash";
        }else {
            return "login";
        }

    }


    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // Invalidate the session
        session.invalidate();

        // Redirect to the root URL
        return "redirect:/";
    }


}
