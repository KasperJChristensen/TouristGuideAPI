package com.example.touristguideapi1.controller;

import com.example.touristguideapi1.model.TouristAttraction;
import com.example.touristguideapi1.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("attractions")
public class TouristController {
    private final TouristService service;

    public TouristController(TouristService touristService) {
        this.service = touristService;
    }

    @GetMapping
    public String getAttractions(Model model) {
        ArrayList<TouristAttraction> attractions = service.getAttractions();
        model.addAttribute("attractions", attractions);
        return "showattractions";
    }

    @GetMapping("/{name}")
    public String findAttractionByName(@PathVariable String name, Model model) {
        TouristAttraction attraction = service.findAttractionByName(name);
        if (attraction == null) {
            model.addAttribute("errorMessage", "The attraction " + name + " has not been found");
            return "error";
        }
        model.addAttribute("attraction", attraction);
        return "attraction";

    }

    @PostMapping("/add")
    public String addAttraction(@ModelAttribute TouristAttraction attraction) {
        service.addAttraction(attraction);
        return "redirect:/attractions";
    }

    @PostMapping("/delete/{name}")
    public String removeAttraction(@PathVariable String name, Model model) {
        TouristAttraction attraction = service.removeAttraction(name);
        if (attraction == null) {
            throw new IllegalArgumentException("No attraction matches the name" + name);
        }
        model.addAttribute("attraction", attraction);
        return "attraction-delete";
    }

    @PostMapping("/update")
    public String updatedAttraction(@ModelAttribute TouristAttraction attraction) {
        service.updatedAttraction(attraction);
        return "redirect:/attractions";
    }

    @PostMapping("/save")
    public String saveAttraction(@ModelAttribute TouristAttraction attraction) {
        service.addAttraction(attraction);
        return "redirect:/attractions";
    }

}