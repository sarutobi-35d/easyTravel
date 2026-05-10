package com.mvp.easyTravel.service;

import com.mvp.easyTravel.dto.AgencyOwnerDto;
import com.mvp.easyTravel.entity.Utilisateur;

public interface UtilisateurService {

    Utilisateur inscrire(AgencyOwnerDto agencyOwnerDto);

}
