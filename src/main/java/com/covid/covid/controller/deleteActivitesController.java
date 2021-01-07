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

import java.sql.Date;
import java.util.List;

@Controller
public class deleteActivitesController {

    @Autowired
    private ActiviteRepository activiteRepository;

    @Autowired
    private LieuRepository lieuRepository;

    @RequestMapping(value = "admin/deleteModifyActivites", method = RequestMethod.GET)
    public String displayActivites(Model model) {

        List<Activite> activites = activiteRepository.findAll();

        model.addAttribute("activites", activites);

        return "admin/deleteModifyActivites";
    }

    @PostMapping("/admin/deleteActivites")
    public String deleteActivities(@RequestParam int id) {

        List<Activite> _activite = activiteRepository.findActiviteById(id);

        Activite activite = _activite.get(0);

        activiteRepository.delete(activite);

        return "redirect:/admin/deleteModifyActivites";
    }

    @PostMapping("/admin/modifyActivity")
    public String modifyActivity(@RequestParam int activityModify,
                                 @RequestParam int heureDebut,
                                 @RequestParam int heureFin,
                                 @RequestParam Date date) {

        List<Activite> _activite = activiteRepository.findActiviteById(activityModify);

        Activite activite = _activite.get(0);

        activite.setHeureDebut(heureDebut);
        activite.setHeureFin(heureFin);
        activite.setDate(date);

        activiteRepository.save(activite);

        return "redirect:/admin/deleteModifyActivites";
    }

}
