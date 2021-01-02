package com.covid.covid.controller;

import com.covid.covid.model.User;
import com.covid.covid.repository.FriendshipRepository;
import com.covid.covid.repository.NotificationRepository;
import com.covid.covid.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FriendController {

    @Autowired
    private FriendshipRepository friendshipRepository;

    @Autowired
    private NotificationRepository notificationRepository;

    @PostMapping("/addfriend")
    public String addFriend(@ModelAttribute("addFriendForm") User userForm, BindingResult bindingResult) {

        //C'est ici qu'il faut faire des vérifications avec bindingResult pour l'instant rien n'est fait



        return "redirect:/addfriend";
    }

}
