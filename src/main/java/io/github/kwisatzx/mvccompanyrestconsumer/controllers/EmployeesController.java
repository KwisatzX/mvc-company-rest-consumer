package io.github.kwisatzx.mvccompanyrestconsumer.controllers;

import io.github.kwisatzx.mvccompanyrestconsumer.RestClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
