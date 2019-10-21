package com.jfsaaved.shopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LandingPageController {

    @GetMapping("/")
    public String LandingPageController(Model model){
        model.addAttribute("controllerName", "LandingPage");
        return "landingpage";
    }
}
