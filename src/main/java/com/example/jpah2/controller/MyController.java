package com.example.jpah2.controller;

import com.example.jpah2.model.Department;
import com.example.jpah2.model.Employee;
import com.example.jpah2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MyController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/depts")
    public ResponseEntity<List<Department>> getDepartments() {
        List<Department> allDepartments = employeeService.getAllDepartments();
        return ResponseEntity.ok().body(allDepartments);
    }

    @GetMapping("/emps")
    public ResponseEntity<List<Employee>> getEmployees() {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return ResponseEntity.ok().body(allEmployees);
    }

    @PostMapping("/depts/{name}")
    public ResponseEntity<Department> createDepartment(@PathVariable String name) {
        Department department = employeeService.createDepartment(name);
        return ResponseEntity.ok().body(department);
    }

    @PostMapping("/depts/{dept}/{emp}/{salary}")
    public ResponseEntity<Employee> createEmployee(
            @PathVariable String dept,
            @PathVariable String emp,
            @PathVariable double salary) {
        Employee employee = employeeService.createEmployee(emp, salary, dept, null);
        return ResponseEntity.ok().body(employee);
    }
}
