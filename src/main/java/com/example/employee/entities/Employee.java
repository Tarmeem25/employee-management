package com.example.employee.entities;

import javax.persistence.*;

@Entity
@Table
public class Employee {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String username;
        private int age;
        private String address;
        private String password;

    public Employee(String username, int age, String address, String password) {
        this.username = username;
        this.age = age;
        this.address = address;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username= username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {return password;}

    public void setPassword(String password) {  this.password = password;}

    public Employee() {
    }

    public Employee(int id, String username, int age, String address,String password) {
        this.username = username;
        this.id = id;
        this.age = age;
        this.address = address;
        this.password = password;
    }
}
