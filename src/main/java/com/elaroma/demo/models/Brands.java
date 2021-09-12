package com.elaroma.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Brands {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String brand_name;
    private boolean brand_checked;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public boolean isBrand_checked() {
        return brand_checked;
    }

    public void setBrand_checked(boolean brand_checked) {
        this.brand_checked = brand_checked;
    }
}
