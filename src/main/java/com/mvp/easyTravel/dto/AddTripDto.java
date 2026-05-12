package com.mvp.easyTravel.dto;

import com.mvp.easyTravel.entity.enums.TypeBus;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public class AddTripDto {

    @NotBlank(message = "Ville de départ obligatoire.")
    private String villeDepart;
    @NotBlank(message = "Ville d'arrivée obligatoire.")
    private String villeArrivee;
    @NotBlank(message = "Lieu d'embarquement obligatoire.")
    private String lieuEmbarquement;
    @NotBlank(message = "Contact de l'embarquement obligatoire.")
    private String contactEmbarquement;
    @NotBlank(message = "Heure de départ obligatoire.")
    private LocalDateTime heureDepart;
    @NotBlank(message = "Prix du voyage obligatoire.")
    @Min(value = 0)
    private Double prix;
    @NotBlank(message = "Choisissez le type de bus.")
    private TypeBus typeBus;

    //CONSTRUCTORS
    public AddTripDto() {
    }

    public AddTripDto(String villeDepart, String villeArrivee,
                      String lieuEmbarquement, String contactEmbarquement,
                      LocalDateTime heureDepart, Double prix, TypeBus typeBus) {
        super();
        this.villeDepart = villeDepart;
        this.villeArrivee = villeArrivee;
        this.lieuEmbarquement = lieuEmbarquement;
        this.contactEmbarquement = contactEmbarquement;
        this.heureDepart = heureDepart;
        this.prix = prix;
        this.typeBus = typeBus;
    }


    //GETTERS & SETTERS
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

    public void setContactEmbarquement(String contactEmbarquement) {
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
}
