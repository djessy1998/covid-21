package com.covid.covid.controller;

import com.covid.covid.model.Activite;
import com.covid.covid.model.Lieu;
import com.covid.covid.model.User;
import com.covid.covid.repository.UsersRepository;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class deleteUsersController {

    @Autowired
    private UsersRepository usersRepository;

    @RequestMapping(value = "admin/deleteUsers", method = RequestMethod.GET)
    public String displayUsers(Model model) {

        List<User> users = usersRepository.findUsers();

        model.addAttribute("users", users);

        return "admin/deleteUsers";
    }

    @PostMapping("/admin/deleteUser")
    public String deleteUser(@RequestParam String user) {

        List<User> _user = usersRepository.findUser(user);

        usersRepository.delete(_user.get(0));

        return "redirect:/admin/deleteUsers";
    }

}
