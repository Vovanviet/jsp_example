package com.employee.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer id;
    private String fullname;
    private String address;
    private String position;
    private String department;

    public Employee() {
    }

    public Employee(String fullname,String address, String position, String department) {
        this.fullname = fullname;
        this.address = address;
        this.position = position;
        this.department = department;
    }

    public Employee(Integer id, String fullname, String address, String position, String department) {
        this.id = id;
        this.fullname = fullname;
        this.address = address;
        this.position = position;
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
