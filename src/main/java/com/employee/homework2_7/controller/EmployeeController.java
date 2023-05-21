package com.employee.homework2_7.controller;

import com.employee.homework2_7.model.Employee;
import com.employee.homework2_7.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/all")
    public Collection<Employee> all() {
        return employeeService.getAll();
    }
    @GetMapping("/add")
    public Employee add(Employee employee) {
        return employeeService.add(employee);
    }
    @GetMapping("/remove")
    public Employee remove(Employee employee) {
        return employeeService.remove(employee);
    }
    @GetMapping("/find")
    public Employee find(Employee employee) {
        return employeeService.find(employee);
    }
}
