package com.helena.dataaccess;

import com.helena.domain.Employee;

import javax.ejb.Local;
import java.util.List;

@Local
public interface DataAccess {
    public void insert(Employee employee);
    public List<Employee> findAll();
    public List<Employee> findByLastname(String lastname);
}
