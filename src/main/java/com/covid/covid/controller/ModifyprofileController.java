package com.covid.covid.controller;

import com.covid.covid.model.User;
import com.covid.covid.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value="/modifyprofile")

public class ModifyprofileController {

    @Autowired
    private UserDetailsServiceImpl userService;


    @RequestMapping(value = "/saveUsername", method = RequestMethod.POST)
    public String saveUsername(@RequestParam("username") String username){
        // TODO : vérifications de username

        final User user =
                (User) SecurityContextHolder.getContext()
                        .getAuthentication()
                        .getPrincipal();

        userService.changeUsername(user, username);
        return "/modifyprofile";
    }

    @RequestMapping(value= "/saveFirstName", method = RequestMethod.POST)
    public String saveFirstName(@RequestParam("firstname") String firstname){

        final User user =
                (User) SecurityContextHolder.getContext()
                        .getAuthentication()
                        .getPrincipal();

        userService.changeFirstName(user, firstname);
        return "/modifyprofile";
    }

    @RequestMapping(value = "/saveLastName", method = RequestMethod.POST)
    public String saveLastName(@RequestParam("lastname") String lastname){

        final User user =
                (User) SecurityContextHolder.getContext()
                        .getAuthentication()
                        .getPrincipal();

        userService.changeLastName(user, lastname);
        return "/modifyprofile";
    }

    @RequestMapping(value = "/savePassword", method = RequestMethod.POST)
    public String savePassword(@RequestParam("password") String password,
                               @RequestParam("password-check") String passwordCheck){
        if (password.equals(passwordCheck)){
            final User user =
                    (User) SecurityContextHolder.getContext()
                            .getAuthentication()
                            .getPrincipal();

            userService.changePassword(user, password);

        }
        return "/modifyprofile";
    }

    @RequestMapping(value = "/saveImage", method= RequestMethod.POST)
    public String saveImage(@RequestParam("image") MultipartFile image){
        final User user =
                (User) SecurityContextHolder.getContext()
                        .getAuthentication()
                        .getPrincipal();

        userService.changeImage(user, image);
        return "/modifyprofile";
    }
}
