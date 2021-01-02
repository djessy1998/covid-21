package com.covid.covid.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
public class Activite {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private String idActivite;

    private int idUser;

    private Date date;

    private int heureDebut;

    private int heureFin;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Lieu> listeLieux;

    public void setId(String id) {
        this.idActivite = id;
    }

    public String getId() {
        return idActivite;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(int heureDebut) {
        this.heureDebut = heureDebut;
    }

    public int getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(int heureFin) {
        this.heureFin = heureFin;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public List<Lieu> getListeLieux() {
        return listeLieux;
    }

    public void setListeLieux(List<Lieu> listeLieux) {
        this.listeLieux = listeLieux;
    }
}
