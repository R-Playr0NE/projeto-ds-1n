package com.projeto1N.exemplo1N.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projetoDsN1")
public class ProjetoDsController {
    @GetMapping
    public String index(Model model){
        return "index";
    }
}
