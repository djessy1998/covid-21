package com.covid.covid.controller;

import com.covid.covid.model.User;
import com.covid.covid.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class deleteUsersController {

    @Autowired
    private UsersRepository usersRepository;

    @RequestMapping(value = "admin/deleteModifyUsers", method = RequestMethod.GET)
    public String displayUsers(Model model) {

        List<User> users = usersRepository.findUsers();

        model.addAttribute("users", users);

        return "admin/deleteModifyUsers";
    }

    @PostMapping("/admin/deleteUser")
    public String deleteUser(@RequestParam String user) {

        List<User> _user = usersRepository.findUser(user);

        usersRepository.delete(_user.get(0));

        return "admin/deleteModifyUsers";
    }

    @PostMapping("/admin/modifyUser")
    public String modifyUser(@RequestParam String userModify,
                             @RequestParam String firstName,
                             @RequestParam String lastName) {


        List<User> _user = usersRepository.findUser(userModify);

        User u = _user.get(0);
        u.setFirstName(firstName);
        u.setLastName(lastName);

        usersRepository.save(u);

        return "redirect:/admin/deleteModifyUsers";
    }

}
