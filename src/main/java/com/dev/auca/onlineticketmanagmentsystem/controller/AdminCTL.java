package com.dev.auca.onlineticketmanagmentsystem.controller;

import com.dev.auca.onlineticketmanagmentsystem.model.Admin;
import com.dev.auca.onlineticketmanagmentsystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminCTL {
    @Autowired
    private AdminService adminService;
    @PostMapping("/newAdmin")
    public ResponseEntity<Admin> newAdmin(@RequestBody Admin admin) {
        Admin newAdmin= adminService.newAdmin(admin);
        return new ResponseEntity<>(newAdmin, HttpStatus.CREATED);

    }
    @GetMapping("/allAdmin")
    public ResponseEntity<List<Admin>> getAll(){
        List<Admin> admins= adminService.allAdmins();
        return new ResponseEntity<>(admins, HttpStatus.OK);

    }


}
