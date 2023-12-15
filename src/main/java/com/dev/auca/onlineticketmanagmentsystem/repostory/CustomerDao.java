package com.dev.auca.onlineticketmanagmentsystem.repostory;

import com.dev.auca.onlineticketmanagmentsystem.model.Customer;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerDao extends JpaRepository<Customer,Integer> {
    @Query("from Customer where email=:email and password=:password")
    Customer login(String email,String password);
//    @Query("from Customer where customerId=:searchText or nId=:searchText or names=:searchText or email=:searchText or phone=:searchText")
//    Customer searchCustomerBy(String searchText);
}
