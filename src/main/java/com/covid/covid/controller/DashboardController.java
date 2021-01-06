package com.covid.covid.controller;

import com.covid.covid.model.Activite;
import com.covid.covid.model.Lieu;
import com.covid.covid.model.Notification;
import com.covid.covid.model.User;
import com.covid.covid.repository.ActiviteRepository;
import com.covid.covid.repository.LieuRepository;
import com.covid.covid.repository.NotificationRepository;
import com.covid.covid.repository.UsersRepository;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Controller
public class DashboardController {

    @Autowired
    private ActiviteRepository activiteRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private LieuRepository lieuRepository;

    @Autowired
    private NotificationRepository notificationRepository;


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

    @PostMapping("/positive")
    public String positive(Model model) {

        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        List<Activite> activiteList = activiteRepository.findActivite((int)principal.getUserId());

        List<User> usersRisk = new ArrayList<>();

        for(Activite a: activiteList){
            String nomLieu = a.getNomLieu();
            List<User> usersRisqueTemp = usersRepository.findUserRisk(nomLieu, principal.getUserId(),
                                         a.getHeureDebut(), a.getHeureFin());
            usersRisk.addAll(usersRisqueTemp);
        }

        for(User u: usersRisk){

            Notification n = new Notification();
            n.setContenu("INFECTED");

            Date utilDate = new Date();
            n.setDate(new java.sql.Date(utilDate.getTime()));

            n.setIdEnvoyeur((int)principal.getUserId());
            n.setIdReceveur((int)u.getUserId());

            n.setType("PASSIVE");

            notificationRepository.save(n);

        }

        return "redirect:/dashboard";
    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String afficherActivites(Model model) {

        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        List<Notification> notifications = notificationRepository.findNotifications((int)principal.getUserId());

        List<Activite> activites = activiteRepository.findActivite((int)principal.getUserId());

        model.addAttribute("activites", activites);
        model.addAttribute("notifications", notifications);
        model.addAttribute("NbNotifications", notifications.size());

        return "dashboard";
    }

    public static Timestamp convert(java.util.Date date)
    {
        return new Timestamp(date.getTime());
    }
}
