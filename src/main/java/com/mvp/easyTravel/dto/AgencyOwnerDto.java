package com.mvp.easyTravel.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AgencyOwnerDto {

    @NotBlank(message = "Le nom de l'agence obligatoire")
    private String nameAgence;
    @NotBlank(message = "Le siege social de l'agence obligatoire")
    private String siegeSocial;
    @NotBlank(message = "Mauvais code, reéssayez.")
    private String codeInvitation;
    @NotBlank(message = "Votre nom est obligatoire")
    private String nom;
    @NotBlank(message = "Votre email est obligatoire")
    @Email(message = "Format invalide")
    private String email;
    @NotBlank(message = "Mot de passe obligatoire")
    @Size(min = 4, max = 12, message = "Longueur définie entre 4 et 12 caractères")
    private String mdp;
    @NotBlank(message = "Mauvaise confirmation du mot de passe")
    private String confirmMdp;

    //CONSTRUCTORS
    public AgencyOwnerDto() {
    }

    public AgencyOwnerDto(String nameAgence, String siegeSocial,
                          String codeInvitation, String nom,
                          String email, String mdp, String confirmMdp) {
        super();
        this.nameAgence = nameAgence;
        this.siegeSocial = siegeSocial;
        this.codeInvitation = codeInvitation;
        this.nom = nom;
        this.email = email;
        this.mdp = mdp;
        this.confirmMdp = confirmMdp;
    }

    //GETTERS & SETTERS
    public String getNameAgence() {
        return nameAgence;
    }

    public void setNameAgence(String nameAgence) {
        this.nameAgence = nameAgence;
    }

    public String getSiegeSocial() {
        return siegeSocial;
    }

    public void setSiegeSocial(String siegeSocial) {
        this.siegeSocial = siegeSocial;
    }

    public String getCodeInvitation() {
        return codeInvitation;
    }

    public void setCodeInvitation(String codeInvitation) {
        this.codeInvitation = codeInvitation;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getConfirmMdp() {
        return confirmMdp;
    }

    public void setConfirmMdp(String confirmMdp) {
        this.confirmMdp = confirmMdp;
    }

}
