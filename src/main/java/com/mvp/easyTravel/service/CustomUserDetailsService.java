package com.mvp.easyTravel.service;

import com.mvp.easyTravel.entity.Utilisateur;
import com.mvp.easyTravel.repository.UsersRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UsersRepository usersRepository;

    public CustomUserDetailsService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Utilisateur utilisateur = usersRepository.findByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException(
                        "Utilisateur non trouvé avec l'email" + email));

        return new CustomUserDetails(utilisateur);
    }
}
