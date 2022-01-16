package com.example.securitydemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/*
    TODO 1 Przekierowanie na login

        Utwórz kontroler: /login przekierowuje na login.html (html jest już dodany w resources/templates)
 */
@RestController
public class LoginController {
    @GetMapping("/login")
    public ModelAndView list(){
        return new ModelAndView("login");
    }
}
