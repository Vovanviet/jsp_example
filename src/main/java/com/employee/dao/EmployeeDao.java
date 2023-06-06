package com.employee.dao;

import com.employee.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    String createOrUpdate(Employee model);
    List<Employee> getAll();
    void deleteById(int id);
}
