package com.example.demo.entity;

import com.example.demo.repository.CustomerOnly;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Customers")
public class Customer {
    @Id
    @GeneratedValue
    private Long id;

    @Nationalized
    @Column(name = "customer_name", length = 500)
    @JsonView(CustomerOnly.class)
    private String customerName;

    @JsonView(CustomerOnly.class)
    private String address;

    //JoinTest Column
    //When we look up customer, the jointest will shown as column in customer table
//    Solution 1:
//    @OneToOne
//    @JoinColumn(name = "join_column")
//    JoinTest joinTest;
//    Better Solution
//    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
//    //@JoinTable(name = "customer_joinlist", joinColumns = {@JoinColumn(name = "customer_id")}, inverseJoinColumns = {@JoinColumn(name = "joinlist")})
//    private List<JoinTest> joinTestList;

    public Customer() {
    }

    public Customer(Long id, String name, String address) {
        this.id = id;
        this.customerName = name;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

//    public List<JoinTest> getJoinTestList() {
//        return joinTestList;
//    }
//
//    public void setJoinTestList(List<JoinTest> joinTestList) {
//        this.joinTestList = joinTestList;
//    }
}
