package com.employee.homework2_5.service;

import com.employee.homework2_5.exception.EmployeeAlreadyAddedException;
import com.employee.homework2_5.exception.EmployeeNotFoundException;
import com.employee.homework2_5.exception.EmployeeStorageIsFullException;
import com.employee.homework2_5.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Service
public class EmployeeService {
    private static final int size_limit = 5;
    private final Collection<Employee> employees = new ArrayList<>(size_limit);
    public Collection<Employee> getAll() {
        return Collections.unmodifiableCollection(employees);
    }
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName,lastName);
        if (employees.size()>=size_limit) {
            throw new EmployeeStorageIsFullException();
        }
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
        return employee;
    }
    public Employee find(String firstName, String lastName) {
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException();
    }
    public Employee remove (String firstName, String lastName) {
        Employee employee = find(firstName, lastName);
        employees.remove(employee);
        return employee;
    }
}
