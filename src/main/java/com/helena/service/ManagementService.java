package com.helena.service;

import com.helena.domain.Employee;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface ManagementService {
    public void registerEmployee(Employee employee);
    public List<Employee> getAllEmployees();
    public List<Employee> searchByLastname(String lastname);
}
