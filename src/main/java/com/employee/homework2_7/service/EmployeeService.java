package com.employee.homework2_7.service;


import com.employee.homework2_7.exception.EmployeeAlreadyAddedException;
import com.employee.homework2_7.exception.EmployeeNotFoundException;
import com.employee.homework2_7.exception.EmployeeStorageIsFullException;
import com.employee.homework2_7.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    private static final int size_limit = 5;
    private final Map<String, Employee> employees = new HashMap<>(size_limit);
    public Collection<Employee> getAll() {
        return employees.values();
    }
    public Employee add(Employee employee) {
        if (employees.size()>=size_limit) {
            throw new EmployeeStorageIsFullException();
        }
        if (employees.containsKey(createKey(employee))) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(createKey(employee), employee);
        return employee;
    }
    public Employee find(Employee employee) {
        employee = employees.get(createKey(employee).toLowerCase());
        if (employee == null) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }
    public Employee remove (Employee employee) {
        employee = employees.get(createKey(employee).toLowerCase());
        if (employee == null) {
            throw new EmployeeNotFoundException();
        }
        return employees.remove(createKey(employee).toLowerCase());
    }
    public static String createKey(Employee employee) {
        return (employee.getFirstName() + employee.getLastName()).toLowerCase();
    }
}
