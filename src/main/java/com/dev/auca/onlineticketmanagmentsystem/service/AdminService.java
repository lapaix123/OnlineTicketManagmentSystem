package com.dev.auca.onlineticketmanagmentsystem.service;

import com.dev.auca.onlineticketmanagmentsystem.model.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminService {
    Admin newAdmin(Admin admin);
    List<Admin> allAdmins();
    Optional<Admin> findById(Integer adminId);
    Admin updateAdmin(Integer adminId, Admin updatedAdmin);
    void deleteAdmin(Integer adminId);
    Admin login(String email,String password);

}
