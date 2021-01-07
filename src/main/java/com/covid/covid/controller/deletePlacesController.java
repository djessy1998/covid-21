package com.covid.covid.controller;

import com.covid.covid.model.Activite;
import com.covid.covid.model.Lieu;
import com.covid.covid.repository.ActiviteRepository;
import com.covid.covid.repository.LieuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class deletePlacesController {

    @Autowired
    private LieuRepository lieuRepository;

    @Autowired
    private ActiviteRepository activiteRepository;

    @RequestMapping(value = "admin/deletePlaces", method = RequestMethod.GET)
    public String displayPlaces(Model model) {

        List<Lieu> lieux = lieuRepository.findAll();

        model.addAttribute("lieux", lieux);

        return "deleteModifyPlaces";
    }

    @PostMapping("/admin/deletePlaces")
    public String deletePlace(@RequestParam int id) {

        List<Lieu> _places = lieuRepository.findLieuByIdLieu(id);

        lieuRepository.delete(_places.get(0));

        List<Activite> _activitesLie = null;

        return "admin/deleteModifyPlaces";
    }

}
