package com.dev.auca.onlineticketmanagmentsystem.service.implementation;

import com.dev.auca.onlineticketmanagmentsystem.model.Customer;
import com.dev.auca.onlineticketmanagmentsystem.repostory.CustomerDao;
import com.dev.auca.onlineticketmanagmentsystem.service.CustomerService;
import com.dev.auca.onlineticketmanagmentsystem.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerImplementation implements CustomerService {
    @Autowired
    private CustomerDao dao;
    @Autowired
    private EmailService emailService;
    @Override
    public Customer newCustomer(Customer customer) {
        Customer customer1= dao.save(customer);
        if(customer1 != null){
            emailService.sendEmail(customer);
            return customer1;
        }else{
            return null;
        }


    }

    @Override
    public void deleteCustomer(Integer customerId) {
        if(dao.existsById(customerId)){
            dao.deleteById(customerId);
        }

    }

    @Override
    public Customer updateCustomer( Customer customer) {

            return dao.save(customer);

    }

    @Override
    public List<Customer> allCustomers() {
        return dao.findAll();
    }

    @Override
    public Customer login(String email, String password) {
        return dao.login(email, password);
    }

    @Override
    public Customer findById(Integer customerId) {
        return dao.findById(customerId).get();
    }

//    @Override
//    public Customer searchCustomer(String searchText) {
//        return dao.searchCustomerBy(searchText);
//    }
}
