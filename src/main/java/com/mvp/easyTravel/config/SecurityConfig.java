package com.mvp.easyTravel.config;

import com.mvp.easyTravel.service.CustomSuccessHandler;
import com.mvp.easyTravel.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final CustomUserDetailsService customUserDetailsService;
    private final CustomSuccessHandler customSuccessHandler;

    public SecurityConfig(CustomUserDetailsService customUserDetailsService,
                          CustomSuccessHandler customSuccessHandler) {
        this.customUserDetailsService = customUserDetailsService;
        this.customSuccessHandler = customSuccessHandler;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/inscription", "/connexion", "/css/**", "/js/**",
                                "/images/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form-> form
                        .loginPage("/connexion")
                        .loginProcessingUrl("/login") //URL du form login : action
                        .successHandler(customSuccessHandler)
                        .permitAll())
                .logout(logout -> logout
                        .logoutUrl("/logout").logoutSuccessUrl("/connexion?logout")
                        .permitAll()
                );

        return http.build();

    }


}
