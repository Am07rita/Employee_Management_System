package com.ems.dao;

import com.ems.entity.Employee;

public interface EmployeeDAO {
boolean login(String userName,String password);
void saveEmployee(Employee employee);
Employee getEmployeeUsingId(int id);
Employee updateEmployee(int id, Employee employee);
void deleteEmployeeById(int id);
Employee getEmployeeByEmail(String email);
}
