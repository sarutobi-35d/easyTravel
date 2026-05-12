package com.mvp.easyTravel.service;

import com.mvp.easyTravel.dto.AddTripDto;
import com.mvp.easyTravel.entity.Agence;
import com.mvp.easyTravel.entity.Utilisateur;
import com.mvp.easyTravel.entity.Voyage;
import com.mvp.easyTravel.entity.enums.StatutVoyage;
import com.mvp.easyTravel.repository.UsersRepository;
import com.mvp.easyTravel.repository.VoyageRepository;
import org.springframework.stereotype.Service;

@Service
public class VoyageService {

    private final VoyageRepository voyageRepository;
    private final UsersRepository usersRepository;

    public VoyageService(VoyageRepository voyageRepository, UsersRepository usersRepository) {
        this.voyageRepository = voyageRepository;
        this.usersRepository = usersRepository;
    }

    public Voyage addVoyage(AddTripDto addTripDto, String emailUser){

        //1- Trouver user et son agence
        Utilisateur utilisateur = usersRepository.findByEmail(emailUser)
                .orElseThrow(()-> new RuntimeException("No User."));

        //2- Recup agence liée à agent
        Agence agence = utilisateur.getAgence();

        Voyage voyage = new Voyage();
        voyage.setVilleDepart(addTripDto.getVilleDepart());
        voyage.setVilleArrivee(addTripDto.getVilleArrivee());
        voyage.setLieuEmbarquement(addTripDto.getLieuEmbarquement());
        voyage.setContactEnbarquement(addTripDto.getContactEmbarquement());
        voyage.setHeureDepart(addTripDto.getHeureDepart());
        voyage.setPrix(addTripDto.getPrix());
        voyage.setTypeBus(addTripDto.getTypeBus());

        voyage.setAgence(agence);

        voyage.setStatutVoyage(StatutVoyage.EN_COURS_DE_CHARGEMENT);




        return voyageRepository.save(voyage);
    }
}
