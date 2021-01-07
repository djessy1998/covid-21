package com.covid.covid.controller;


import com.covid.covid.model.Activite;
import com.covid.covid.repository.ActiviteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class deleteActivitesController {

    @Autowired
    private ActiviteRepository activiteRepository;

    @RequestMapping(value = "admin/deleteActivites", method = RequestMethod.GET)
    public String displayActivites(Model model) {

        List<Activite> activites = activiteRepository.findAll();

        model.addAttribute("activites", activites);

        return "deleteModifyActivites";
    }

    @PostMapping("/admin/deleteActivites")
    public String deleteUser(@RequestParam int id) {

        List<Activite> _activite = activiteRepository.findActiviteById(id);

        activiteRepository.delete(_activite.get(0));

        return "admin/deleteModifyActivites";
    }

}
