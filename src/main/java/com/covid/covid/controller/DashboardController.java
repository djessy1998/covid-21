package com.covid.covid.controller;

import com.covid.covid.model.Activite;
import com.covid.covid.model.User;
import com.covid.covid.repository.ActiviteRepository;
import com.covid.covid.service.ActiviteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Controller
public class DashboardController {

    @Autowired
    private ActiviteService activiteService;

    @Autowired
    private ActiviteRepository activiteRepository;

    @PostMapping("/dashboard/addActivity")
    public String addActivity(@RequestParam("nom") String nom,
                              @RequestParam("date") String date,
                              @RequestParam("heureDebut") int heureDebut,
                              @RequestParam("heureFin") int heureFin,
                              RedirectAttributes redirectAttributes) {

            redirectAttributes.addFlashAttribute("nom", nom);
            redirectAttributes.addFlashAttribute("date", date);
            redirectAttributes.addFlashAttribute("heureDebut", heureDebut);
            redirectAttributes.addFlashAttribute("heureFin", heureFin);

        return "redirect:/activityPlace";
    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String afficherActivites(Model model) {

        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        List<Activite> activites = activiteRepository.findActivite((int)principal.getUserId());

        model.addAttribute("activites", activites);

        return "dashboard";
    }

    public static Timestamp convert(java.util.Date date)
    {
        return new Timestamp(date.getTime());
    }
}
