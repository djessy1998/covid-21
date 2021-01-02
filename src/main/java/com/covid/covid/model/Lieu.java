package com.covid.covid.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Lieu {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private String idLieu;

    private String denomination;

    private String adresse;

    public void setIdLieu(String idLieu) {
        this.idLieu = idLieu;
    }

    public String getIdLieu() {
        return idLieu;
    }

    public String getDenomination() {
        return denomination;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
