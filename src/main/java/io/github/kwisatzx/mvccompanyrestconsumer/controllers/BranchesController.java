package io.github.kwisatzx.mvccompanyrestconsumer.controllers;

import io.github.kwisatzx.mvccompanyrestconsumer.RestClient;
import io.github.kwisatzx.mvccompanyrestconsumer.model.Branch;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class BranchesController {

    private final RestClient restClient;

    public BranchesController(RestClient restClient) {
        this.restClient = restClient;
    }

    @GetMapping("/branches")
    public String branchesList(Model model) {
        model.addAttribute("branchList", restClient.getList("/branches",
                                                            new ParameterizedTypeReference<List<Branch>>() {}));
        return "branches";
    }

    @GetMapping("/branches/{branchId}")
    public String branchDetails(@PathVariable Long branchId, Model model) {
        model.addAttribute("branch", restClient.getObject(Branch.class, "/branches/" + branchId));
        return "branchDetails";
    }

    public String deleteBranch(Long branchId) {
        restClient.deleteObject("/branches/" + branchId);
        return "branches";
    }
}
