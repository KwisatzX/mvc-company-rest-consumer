package io.github.kwisatzx.mvccompanyrestconsumer.controllers;

import io.github.kwisatzx.mvccompanyrestconsumer.RestClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class EmployeesController {

    private final RestClient restClient;

    public EmployeesController(RestClient restClient) {
        this.restClient = restClient;
    }

    @GetMapping("/employees")
    public String employeeList(Model model) {
        model.addAttribute("employees", restClient.getEmployeeList());
        return "employees";
    }

    @GetMapping("/employees/{empId}")
    public String employeeDetails(@PathVariable Long empId, Model model) {
        model.addAttribute("emp", restClient.getEmployee(empId));
        return "employeeDetails";
    }

    public String deleteEmployee(Long empId) {
        restClient.deleteEmployee(empId);
        return "employees";
    }
}
