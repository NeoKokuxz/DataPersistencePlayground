package com.example.demo.service;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    //Get Customers
    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    //Get Customer By Id
    public Customer getCustomerById(Long id){
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        Customer customer = new Customer();
        if(optionalCustomer.isPresent()){
            customer = optionalCustomer.get();
        }
        return customer;
    }

    //Post Save Customer
    public void saveCustomer(Customer customer){
        customerRepository.save(customer);

    }
}
