package com.covid.covid.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Notification {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;

    private int idEnvoyeur;

    private int idReceveur;

    private boolean vue;

    private String type;

    private String contenu;

    private Date date;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Date getDate() {
        return date;
    }

    public int getIdEnvoyeur() {
        return idEnvoyeur;
    }

    public void setIdEnvoyeur(int idEnvoyeur) {
        this.idEnvoyeur = idEnvoyeur;
    }

    public int getIdReceveur() {
        return idReceveur;
    }

    public void setIdReceveur(int idReceveur) {
        this.idReceveur = idReceveur;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isVue() {
        return vue;
    }

    public void setVue(boolean vue) {
        this.vue = vue;
    }
}
