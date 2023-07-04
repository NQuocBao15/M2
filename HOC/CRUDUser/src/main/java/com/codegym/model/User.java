package com.codegym.model;

import java.time.LocalDate;

public class User {
    private long id;
    private String name;
    private String address;
    private EGender eGender;
    private ERole eRole;
    private LocalDate dob;

    public User() {
    }

    public User(long id, String name, String address, EGender eGender, ERole eRole, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.eGender = eGender;
        this.eRole = eRole;
        this.dob = dob;
    }

    public long getId() {
        return id;
    }

    public long setId(long id) {
        this.id = id;
        return id;
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

    public EGender geteGender() {
        return eGender;
    }

    public void seteGender(EGender eGender) {
        this.eGender = eGender;
    }

    public ERole geteRole() {
        return eRole;
    }

    public void seteRole(ERole eRole) {
        this.eRole = eRole;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return id+","+name+","+address+","+eGender+","+eRole+","+dob;
    }
}
