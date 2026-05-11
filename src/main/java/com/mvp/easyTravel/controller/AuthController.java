package com.mvp.easyTravel.controller;

import com.mvp.easyTravel.dto.AgencyOwnerDto;
import com.mvp.easyTravel.service.UtilisateurService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {

    private final UtilisateurService utilisateurService;

    public AuthController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping("/inscription")
    public String showRegister(Model model){
        model.addAttribute("agencyOwnerDto", new AgencyOwnerDto());
        return "register";
    }

    @PostMapping("/inscription")
    public String registerAgencyOwner(@Valid @ModelAttribute AgencyOwnerDto agencyOwnerDto,
                                      BindingResult bindingResult, Model model,
                                      RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){

            return "register";
        }

        try{
            utilisateurService.inscrire(agencyOwnerDto);
            redirectAttributes.addFlashAttribute("success",
                    "Agence et Agent crées avec succès !");

            return "redirect:/connexion";

        } catch (RuntimeException e) {

            redirectAttributes.addFlashAttribute("error",
                    e.getMessage());
            return "redirect:/inscription";
        }
    }

    @GetMapping("/connexion")
    public String loginNow(){
        return "login";
    }
}
