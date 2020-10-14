package com.example.demo.controller;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.entity.Customer;
import com.example.demo.entity.JoinTest;
import com.example.demo.repository.CustomerOnly;
import com.example.demo.service.CustomerService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/get")
    public String get(){
        return "Data Get Test Successes!";
    }
    @GetMapping("/get/customers")
    //JsonView only display the data in the entity that also marked JsonView
    @JsonView(CustomerOnly.class)
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    @GetMapping("/getDTO/{id}")
    public CustomerDTO getDTO(@PathVariable Long id){
        return convertEntityToCustomerDTO(customerService.getCustomerById(id));
    }

    @PostMapping("/saveDTO")
    public String saveDTO(@RequestBody CustomerDTO customerDTO){
        Customer customer = convertDTOToCustomerEntity(customerDTO);
        customerService.saveCustomer(customer);
        return "Successfully saved DTO into database";
    }

    //Convert Method DTO <-> Entity
    private static CustomerDTO convertEntityToCustomerDTO(Customer customer){
        CustomerDTO customerDTO = new CustomerDTO();
        BeanUtils.copyProperties(customer, customerDTO);
        return customerDTO;
    }

    private static Customer convertDTOToCustomerEntity(CustomerDTO customerDTO){
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO, customer);
        return customer;
    }


    //OneToMany Test
//    @GetMapping("/otm")
//    public String getOTM(){
//        Customer customer = new Customer();
//        customer.setCustomerName("OTM Test 1");
//
//        Set<JoinTest> joinTests = new HashSet<>();
//
//        JoinTest joinTest1 = new JoinTest();
//        joinTest1.setName("JoinTest 1");
//        joinTest1.setAddress("22");
//        joinTest1.setId(1L);
//
//        JoinTest joinTest2 = new JoinTest();
//        joinTest2.setName("JoinTest 2");
//        joinTest2.setAddress("33");
//        joinTest2.setId(2L);
//
//        List<JoinTest> joinTestList = new ArrayList<>();
//
//        joinTestList.add(joinTest1);
//        joinTestList.add(joinTest2);
//
//        customer.setJoinTestList(joinTestList);
//
//        System.out.println(customer.getJoinTestList());
//
//        JoinTest result = customer.getJoinTestList().iterator().next();
//
//        System.out.println(result.getName());
//
//        return "Test OTM";
//    }


}
