package com.example.phase3week1.controllers;

import com.example.phase3week1.models.User;
import com.example.phase3week1.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @Autowired

    LoginService service;

    @GetMapping("/login")
    public String showLoginPage(ModelMap model) {
     return "signup";
 }

    @PostMapping("/login")
    public String loginUser(Model model, @ModelAttribute("user") User user) {

     if (user != null && user.getName() != "" && user.getPassword() != "") {
         if (service.loginUser(user)) {
             return "welcome";
         }
     }
     model.addAttribute("error", "Wrong Password");
     return "signup";
 }

}
