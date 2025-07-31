package com.example.employee.controller;

import com.example.employee.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private Map<Integer, Employee> employeeMap = new HashMap<>();

    @PostMapping
    public String addEmployee(@RequestBody Employee employee) {
        employeeMap.put(employee.getId(), employee);
        return "Employee added successfully!";
    }

    @PutMapping("/{id}")
    public String updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        if (employeeMap.containsKey(id)) {
            employeeMap.put(id, employee);
            return "Employee updated successfully!";
        } else {
            return "Employee not found!";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {
        if (employeeMap.remove(id) != null) {
            return "Employee deleted successfully!";
        } else {
            return "Employee not found!";
        }
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return employeeMap.get(id);
    }

    @GetMapping
    public Collection<Employee> getAllEmployees() {
        return employeeMap.values();
    }
}