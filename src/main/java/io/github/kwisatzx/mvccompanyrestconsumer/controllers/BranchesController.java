package io.github.kwisatzx.mvccompanyrestconsumer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class BranchesController {

    public String branchesList(Model model) {

        return "branches";
    }
}
