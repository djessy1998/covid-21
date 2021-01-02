package com.covid.covid.controller;

import com.covid.covid.service.UserDetailsServiceImpl;
import com.covid.covid.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    @Autowired
    private UserDetailsServiceImpl userService;

    @PostMapping("/register")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {

        //C'est ici qu'il faut faire des vérifications avec bindingResult pour l'instant rien n'est fait

        userService.save(userForm);

        return "redirect:/login";
    }


}
