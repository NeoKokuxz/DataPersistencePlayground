package com.example.demo.entity;

import javax.persistence.*;

@Entity
public class JoinTest {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String address;

    //Customer
    //When we look up JoinTest
    //Customer will be in the column as well
//    @ManyToOne
//    @JoinColumn(name = "customer_id")
//    Customer customer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
