package com.example.demo.entity;

import org.hibernate.annotations.Nationalized;

import javax.persistence.*;

@Entity
@Table(name = "Menu_Item")
public class Item {
    @Id
    @GeneratedValue
    private Long id;

    @Nationalized
    private String itemName;

    @Column(precision = 12, scale = 4)
    private Double price;

    public Item() {
    }

    public Item(Long id, String itemName, Double price) {
        this.id = id;
        this.itemName = itemName;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
