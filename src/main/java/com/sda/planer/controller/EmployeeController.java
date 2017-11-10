package com.sda.planer.controller;

import com.sda.planer.model.Employee;
import com.sda.planer.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/employees")
public class EmployeeController {


    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employeePanel")
    public ModelAndView employeePanel(){
        ModelAndView modelAndView = new ModelAndView("employeePanel");
        modelAndView.addObject("employees", employeeService.getAllEmployees());
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView getEmployee(@PathVariable("id") int id) {
        Employee employee = employeeService.getEmployeeById(id);
        ModelAndView modelAndView = new ModelAndView("employee");
        modelAndView.addObject("employee", employee);
        return modelAndView;
    }

    @PostMapping
    public String addEmployee(@ModelAttribute Employee employee){
        employeeService.addEmployee(employee);
        return "redirect:/employees/employeePanel";
    }

    @PostMapping(consumes = "application/json")
    public String addEmployeeJSON(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
        return "redirect:/users/all";
    }



}
