package com.dev.auca.onlineticketmanagmentsystem.controller;

import com.dev.auca.onlineticketmanagmentsystem.model.Admin;
import com.dev.auca.onlineticketmanagmentsystem.service.AdminService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;
    @GetMapping("/loginAdmin")
    public String loginPAgeAdnmi(Model model) {

        return "adminLogin";

    }
    @GetMapping("adminDash")
    public String getAdminDash(Model model,HttpSession session) {
        Admin authanticatedAdmin=(Admin) session.getAttribute("adminAuthenticated");
        if(authanticatedAdmin != null) {
            model.addAttribute("adminAuthenticated", authanticatedAdmin);
            return "AdminDash";
        }else{
            return "adminLogin";
        }


    }

    @PostMapping("/loginAd")
    public String LoginAdmin(@RequestParam String email, @RequestParam String password, Model model, HttpSession session) {
        Admin admin=adminService.login(email, password);
        if(admin==null){
            model.addAttribute("error","Plz provide Collect Admin Data");
            return "adminLogin";
        }else{
            session.setAttribute("adminAuthenticated",admin);
            return "redirect:/adminDash";
        }

    }

}
