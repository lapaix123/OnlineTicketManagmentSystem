package com.dev.auca.onlineticketmanagmentsystem.repostory;

import com.dev.auca.onlineticketmanagmentsystem.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminDao extends JpaRepository<Admin,Integer> {
    @Query("from Admin where email = :email and password = :password")
    Admin login(String email, String password);
}
