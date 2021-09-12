package com.elaroma.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Capacities {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String cpct;
    private boolean capacity_checked;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpct() {
        return cpct;
    }

    public void setCpct(String cpct) {
        this.cpct = cpct;
    }

    public boolean isCapacity_checked() {
        return capacity_checked;
    }

    public void setCapacity_checked(boolean capacity_checked) {
        this.capacity_checked = capacity_checked;
    }
}