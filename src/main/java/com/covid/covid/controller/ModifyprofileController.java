package com.covid.covid.controller;

import com.covid.covid.model.Activite;
import com.covid.covid.model.Notification;
import com.covid.covid.model.User;
import com.covid.covid.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class ModifyprofileController {

    @Autowired
    private UserDetailsServiceImpl userService;

    @RequestMapping(value = "/modifyprofile", method = RequestMethod.GET)
    public String modifyProfile(Model model) {

        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        model.addAttribute("image", principal.getImage());

        return "modifyprofile";
    }


    @RequestMapping(value = "/modifyprofile/saveUsername", method = RequestMethod.POST)
    public String saveUsername(@RequestParam("username") String username){
        // TODO : vérifications de username

        final User user =
                (User) SecurityContextHolder.getContext()
                        .getAuthentication()
                        .getPrincipal();

        userService.changeUsername(user, username);
        return "redirect:/modifyprofile";
    }

    @RequestMapping(value= "/modifyprofile/saveFirstName", method = RequestMethod.POST)
    public String saveFirstName(@RequestParam("firstname") String firstname){

        final User user =
                (User) SecurityContextHolder.getContext()
                        .getAuthentication()
                        .getPrincipal();

        userService.changeFirstName(user, firstname);
        return "redirect:/modifyprofile";
    }

    @RequestMapping(value = "/modifyprofile/saveLastName", method = RequestMethod.POST)
    public String saveLastName(@RequestParam("lastname") String lastname){

        final User user =
                (User) SecurityContextHolder.getContext()
                        .getAuthentication()
                        .getPrincipal();

        userService.changeLastName(user, lastname);
        return "redirect:/modifyprofile";
    }

    @RequestMapping(value = "/modifyprofile/savePassword", method = RequestMethod.POST)
    public String savePassword(@RequestParam("password") String password,
                               @RequestParam("password-check") String passwordCheck){
        if (password.equals(passwordCheck)){
            final User user =
                    (User) SecurityContextHolder.getContext()
                            .getAuthentication()
                            .getPrincipal();

            userService.changePassword(user, password);

        }
        return "redirect:/modifyprofile";
    }

    @RequestMapping(value = "/modifyprofile/saveImage", method= RequestMethod.POST)
    public String saveImage(@RequestParam("image") MultipartFile image,
                            Model model){
        final User user =
                (User) SecurityContextHolder.getContext()
                        .getAuthentication()
                        .getPrincipal();

        userService.changeImage(user, image);

        return "redirect:/modifyprofile";
    }
}
