package com.dev.auca.onlineticketmanagmentsystem.service;

import com.dev.auca.onlineticketmanagmentsystem.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer newCustomer(Customer customer);
    void deleteCustomer(Integer customerId);
    Customer updateCustomer(Customer customer);
    List<Customer> allCustomers();
    Customer login(String email,String password);
    Customer findById(Integer customerId);
//    Customer searchCustomer(String searchText);
}
