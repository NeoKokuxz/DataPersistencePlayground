package com.example.demo.dto;

public class CustomerDTO {

    private String customerName;
    private String address;

    public CustomerDTO() {
    }

    public CustomerDTO(String customerName, String address) {
        this.customerName = customerName;
        this.address = address;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
