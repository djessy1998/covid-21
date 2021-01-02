package com.covid.covid.controller;

import com.covid.covid.model.Activite;
import com.covid.covid.model.User;
import com.covid.covid.repository.ActiviteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Set;

@Controller
public class DashboardController {

    @Autowired
    private ActiviteRepository activiteRepository;

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String afficherActivites(Model model) {

        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        List<Activite> activites = activiteRepository.findActivite((int)principal.getUserId());

        model.addAttribute("activites", activites);

        return "dashboard";

    }
}
