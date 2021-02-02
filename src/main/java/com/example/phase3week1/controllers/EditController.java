package com.example.phase3week1.controllers;

import com.example.phase3week1.models.User;
import com.example.phase3week1.services.EditService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EditController {
    private EditService service;

    @GetMapping("/welcome")
    public String showSignupPage(ModelMap model) {
        return "welcome";
    }

    @PostMapping("/welcome")
    public String postSignUp(Model model, @ModelAttribute("user") User user) {

        if(user != null && user.getName() != "" && user.getPassword() != "") {
            if(service.editUser(user)) {
                return "login";
            }else {
                model.addAttribute("error", "Username Taken");
                return "welcome";
            }
        }else {
            model.addAttribute("error", "Missing Field");
            return "welcome";
        }
    }
}
