package com.mvp.easyTravel.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "agence")
public class Agence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomAgence;
    private String logo;
    private String siegeSocial;

    //Agence à ++ voyages
    @OneToMany(mappedBy = "agence", cascade = CascadeType.ALL)
    private List<Voyage> voyages;

    //Agence à ++ users
    @OneToMany(mappedBy = "agence")
    private List<Utilisateur> utilisateurs;

    //GETTERS & SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomAgence() {
        return nomAgence;
    }

    public void setNomAgence(String nomAgence) {
        this.nomAgence = nomAgence;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getSiegeSocial() {
        return siegeSocial;
    }

    public void setSiegeSocial(String siegeSocial) {
        this.siegeSocial = siegeSocial;
    }

    public List<Voyage> getVoyages() {
        return voyages;
    }

    public void setVoyages(List<Voyage> voyages) {
        this.voyages = voyages;
    }

    public List<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(List<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }
}
