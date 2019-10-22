package com.jfsaaved.shopping.controller;

import com.jfsaaved.shopping.service.CDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CDController {

    @Autowired
    private CDService cdService;

    @GetMapping("/cds")
    public String list(Model model){
        model.addAttribute("controllerName", "CDs");
        model.addAttribute("cds", cdService.list());
        return "cds/list";
    }

}
