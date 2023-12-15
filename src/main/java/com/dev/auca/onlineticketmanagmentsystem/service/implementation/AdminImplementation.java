package com.dev.auca.onlineticketmanagmentsystem.service.implementation;

import com.dev.auca.onlineticketmanagmentsystem.model.Admin;
import com.dev.auca.onlineticketmanagmentsystem.repostory.AdminDao;
import com.dev.auca.onlineticketmanagmentsystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AdminImplementation implements AdminService {
    @Autowired
    private AdminDao dao;
    @Override
    public Admin newAdmin(Admin admin) {

        return dao.save(admin);
    }

    @Override
    public List<Admin> allAdmins() {
        return dao.findAll();
    }

    @Override
    public Optional<Admin> findById(Integer adminId) {
        return dao.findById(adminId);
    }

    @Override
    public Admin updateAdmin(Integer adminId, Admin admin) {
        Optional<Admin> adminExist = dao.findById(adminId);

        if (adminExist.isPresent()) {
            Admin updateAdmin = adminExist.get();
            updateAdmin.setNames(admin.getNames());
            updateAdmin.setEmail(admin.getEmail());
            updateAdmin.setPhone(admin.getPhone());
            updateAdmin.setPassword(admin.getPassword());


            return dao.save(updateAdmin);
        } else {

            throw new RuntimeException("Admin not found with ID: " + adminId);
        }
    }

    @Override
    public void deleteAdmin(Integer adminId) {
        if (dao.existsById(adminId)) {
            dao.deleteById(adminId);
        } else {

            throw new RuntimeException("Admin not found with ID: " + adminId);
        }

    }

    @Override
    public Admin login(String email, String password) {
        return dao.login(email, password);
    }
}
