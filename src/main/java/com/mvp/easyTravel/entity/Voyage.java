package com.mvp.easyTravel.entity;

import com.mvp.easyTravel.entity.enums.StatutVoyage;
import com.mvp.easyTravel.entity.enums.TypeBus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "voyage")
public class Voyage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String villeDepart;
    private String villeArrivee;
    private String lieuEmbarquement;
    private String contactEmbarquement;
    private LocalDateTime heureDepart;
    private Double prix;
    @Enumerated(EnumType.STRING)
    private TypeBus typeBus;
    @Enumerated(EnumType.STRING)
    private StatutVoyage statutVoyage;

    //++ voyages appartiennent à une seule agence
    @ManyToOne
    @JoinColumn(name = "agence_id", nullable = false)
    private Agence agence;

    //GETTERS & SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVilleDepart() {
        return villeDepart;
    }

    public void setVilleDepart(String villeDepart) {
        this.villeDepart = villeDepart;
    }

    public String getVilleArrivee() {
        return villeArrivee;
    }

    public void setVilleArrivee(String villeArrivee) {
        this.villeArrivee = villeArrivee;
    }

    public String getLieuEmbarquement() {
        return lieuEmbarquement;
    }

    public void setLieuEmbarquement(String lieuEmbarquement) {
        this.lieuEmbarquement = lieuEmbarquement;
    }

    public String getContactEmbarquement() {
        return contactEmbarquement;
    }

    public void setContactEnbarquement(String contactEmbarquement) {
        this.contactEmbarquement = contactEmbarquement;
    }

    public LocalDateTime getHeureDepart() {
        return heureDepart;
    }

    public void setHeureDepart(LocalDateTime heureDepart) {
        this.heureDepart = heureDepart;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public TypeBus getTypeBus() {
        return typeBus;
    }

    public void setTypeBus(TypeBus typeBus) {
        this.typeBus = typeBus;
    }

    public StatutVoyage getStatutVoyage() {
        return statutVoyage;
    }

    public void setStatutVoyage(StatutVoyage statutVoyage) {
        this.statutVoyage = statutVoyage;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }
}
