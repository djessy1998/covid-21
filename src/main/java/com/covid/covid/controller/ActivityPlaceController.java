package com.covid.covid.controller;

import com.covid.covid.model.Activite;
import com.covid.covid.model.Lieu;
import com.covid.covid.model.User;
import com.covid.covid.repository.ActiviteRepository;
import com.covid.covid.repository.LieuRepository;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ActivityPlaceController {

    @Autowired
    private LieuRepository lieuRepository;

    @Autowired
    private ActiviteRepository activiteRepository;

    private Activite activiteEnCours = null;

    private List<Lieu> lieux;

    private Lieu myPlace;

    private String nom;
    private String date;
    private int heureDebut;
    private int heureFin;


    @RequestMapping(value = "/activityPlace", method = RequestMethod.GET)
    public String lieu(Model model, RedirectAttributes redirectAttributes) {

        myPlace = new Lieu();

        if(this.nom == null){
            this.nom = (String) model.asMap().get("nom");
            this.date = (String) model.asMap().get("date");
            this.heureDebut = (int) model.asMap().get("heureDebut");
            this.heureFin = (int) model.asMap().get("heureFin");
        }

        List<Lieu> lieux = lieuRepository.findLieuByNomActivite(this.nom);

        if(model.asMap().get("lieux") != null) {
            model.addAttribute("lieux", model.asMap().get("lieux"));
        } else {
            model.addAttribute("lieux", lieux);
        }

        model.addAttribute("myPlace", myPlace);

        return "activityPlace";
    }

    @RequestMapping(value="/saveActivity")
    public String addActivity(@ModelAttribute("myPlace") Lieu lieuForm,
                              Model model, Request request) {

        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        try {
            Activite activite = new Activite();
            activite.setNom(nom);

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsed = format.parse(date);
            java.sql.Date sql = new java.sql.Date(parsed.getTime());

            activite.setDate(sql);
            activite.setHeureDebut(heureDebut);
            activite.setHeureFin(heureFin);
            activite.setIdUser((int)principal.getUserId());

            activiteRepository.save(activite);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "redirect:/dashboard";
    }

    @PostMapping("/addPlace")
    public String addLieu(@RequestParam String nom,
                          @RequestParam String adresse,
                          Model model,
                          RedirectAttributes redirectAttributes) {

        this.lieux = new ArrayList<>();

        Lieu l = new Lieu();
        l.setAdresse(adresse);
        l.setDenomination(nom);
        l.setNomActivite(this.nom);

        this.lieuRepository.save(l);

        List<Lieu> lieux = lieuRepository.findLieuByNomActivite(this.nom);
        this.lieux.addAll(lieux);

        redirectAttributes.addFlashAttribute("lieux", this.lieux);

        return "redirect:/activityPlace";
    }


}
