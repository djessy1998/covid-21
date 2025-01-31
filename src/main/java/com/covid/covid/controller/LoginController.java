package com.covid.covid.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class LoginController {

    @RequestMapping(value="/", method= RequestMethod.GET)
    public String loginDefault(Principal principal) {
        return principal == null ?  "login" : "redirect:/dashboard";
    }


    @RequestMapping(value="/login", method= RequestMethod.GET)
    public String login(Principal principal) {
        return principal == null ?  "login" : "redirect:/dashboard";
    }

}
