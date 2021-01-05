package com.covid.covid.service;

import com.covid.covid.model.Activite;
import com.covid.covid.model.User;
import com.covid.covid.repository.ActiviteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.sql.Date;


@Service
public class ActiviteService {

    @Autowired
    ActiviteRepository activiteRepository;

    public Activite save(String nom, Date date, int heureDebut, int heureFin){

        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Activite activite = new Activite();
        activite.setDate(date);
        activite.setHeureDebut(heureDebut);
        activite.setHeureFin(heureFin);
        activite.setNom(nom);
        activite.setIdUser((int)principal.getUserId());

        return activiteRepository.save(activite);
    }

}
