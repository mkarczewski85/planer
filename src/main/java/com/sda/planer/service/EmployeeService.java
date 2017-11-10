package com.sda.planer.service;

import com.sda.planer.model.Employee;
import com.sda.planer.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {


    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(long id){
        return employeeRepository.findOne(id);
    }

    public void addEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    public void deleteEmployee(long id){
        employeeRepository.delete(id);
    }


}
