package io.github.kwisatzx.mvccompanyrestconsumer.controllers;

import io.github.kwisatzx.mvccompanyrestconsumer.RestClient;
import io.github.kwisatzx.mvccompanyrestconsumer.model.Employee;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class EmployeesController {

    private final RestClient restClient;

    public EmployeesController(RestClient restClient) {
        this.restClient = restClient;
    }

    @GetMapping("/employees")
    public String employeeList(Model model) {
        model.addAttribute("employeeList", restClient.getList("/employees",
                                                       new ParameterizedTypeReference<List<Employee>>() {}));
        return "employees";
    }

    @GetMapping("/employees/{empId}")
    public String employeeDetails(@PathVariable Long empId, Model model) {
        model.addAttribute("emp", restClient.getObject(Employee.class, "/employees/" + empId));
        return "employeeDetails";
    }

    public String deleteEmployee(Long empId) {
        restClient.deleteObject("/employees/" + empId);
        return "employees";
    }
}
