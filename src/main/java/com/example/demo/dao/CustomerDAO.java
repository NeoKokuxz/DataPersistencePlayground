package com.example.demo.dao;

import com.example.demo.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> customerList();
    void addToDelivery(Long customerId, Long deliveryId);
    List<Customer> findByCustomerId(Long customerId);
}
