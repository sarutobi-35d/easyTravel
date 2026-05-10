package com.mvp.easyTravel.service;

import com.mvp.easyTravel.dto.AgencyOwnerDto;
import com.mvp.easyTravel.entity.Agence;
import com.mvp.easyTravel.entity.Utilisateur;
import com.mvp.easyTravel.entity.enums.Role;
import com.mvp.easyTravel.repository.AgenceRepository;
import com.mvp.easyTravel.repository.UsersRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UtilisateursServiceImpl implements UtilisateurService {

    private final UsersRepository usersRepository;
    private final AgenceRepository agenceRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${app.security.invitation-code}")
    private String codeSecretValide;

    public UtilisateursServiceImpl(UsersRepository usersRepository,
                                   AgenceRepository agenceRepository,
                                   PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.agenceRepository = agenceRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    @Override
    public Utilisateur inscrire(AgencyOwnerDto agencyOwnerDto) {

        if (!codeSecretValide.equals(agencyOwnerDto.getCodeInvitation())){
            throw new RuntimeException("Code d'invitation invalide.");
        }

        if(!agencyOwnerDto.getMdp().equals(agencyOwnerDto.getConfirmMdp())){
            throw new RuntimeException("Les mots de passe ne correspondent pas.");
        }
        if (usersRepository.findByEmail(agencyOwnerDto.getEmail()).isPresent()){
            throw new RuntimeException("Email existe déjà !!!");
        }

        Agence agence = new Agence();
        agence.setNomAgence(agencyOwnerDto.getNameAgence());
        agence.setSiegeSocial(agencyOwnerDto.getSiegeSocial());

        //Save d'abord agence pour générer son id
        Agence agenceEnregistree = agenceRepository.save(agence);

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom(agencyOwnerDto.getNom());
        utilisateur.setEmail(agencyOwnerDto.getEmail());
        utilisateur.setPassword(passwordEncoder.encode(agencyOwnerDto.getMdp()));
        utilisateur.setRole(Role.ROLE_AGENT);

        //Lier user à agence enregistree
        utilisateur.setAgence(agenceEnregistree);

        return usersRepository.save(utilisateur);

    }
}
