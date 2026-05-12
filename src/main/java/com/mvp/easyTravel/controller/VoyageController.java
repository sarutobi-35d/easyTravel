package com.mvp.easyTravel.controller;

import com.mvp.easyTravel.dto.AddTripDto;
import com.mvp.easyTravel.entity.enums.TypeBus;
import com.mvp.easyTravel.service.VoyageService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
public class VoyageController {

    private final VoyageService voyageService;

    public VoyageController(VoyageService voyageService) {
        this.voyageService = voyageService;
    }

    @GetMapping("/voyage")
    public String showTripForm (Model model){

        model.addAttribute("addTripDto", new AddTripDto());
        model.addAttribute("typeBus", TypeBus.values());

        return "voyage";
    }

    @PostMapping("/voyage/add")
    public String addTrip(@Valid @ModelAttribute("voyage") AddTripDto addTripDto,
                          BindingResult bindingResult, Model model,
                          RedirectAttributes redirectAttributes,
                          Principal principal){

        if (bindingResult.hasErrors()){
            return "voyage";
        }

        try{
            //1. Recup email du user connecté via le Principal
            String email = principal.getName();

            voyageService.addVoyage(addTripDto, email);
            redirectAttributes.addFlashAttribute("success",
                    "Informations sur le voyage enregistrées avec succès.");

            return "redirect:/dashboard";

        } catch (RuntimeException e){
            redirectAttributes.addFlashAttribute("error",
                    e.getMessage());

            return "redirect:/voyage/add";
        }
    }


}
