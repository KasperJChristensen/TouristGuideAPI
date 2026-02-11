package com.example.touristguideapi1.controller;

import com.example.touristguideapi1.model.Category;
import com.example.touristguideapi1.model.TouristAttraction;
import com.example.touristguideapi1.service.TouristService;
import org.apache.catalina.User;
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
            model.addAttribute("errorMessage", "The attraction" + name + "has not been found");
            return "error";
        }
        model.addAttribute("attraction", attraction);
        return "attraction";
    }

    @PostMapping("/add")
    public String addAttraction(@ModelAttribute TouristAttraction attraction) {
        service.addAttraction(attraction);
        return "redirect:/attraction/attraction";
    }

    @GetMapping("/edit")
    public String editAttraction(@PathVariable String attraction, Model model){
        TouristAttraction a = service.findAttractionByName(attraction);
        if(a==null){
            throw new IllegalArgumentException("Unknow attraction");
        }
        model.addAttribute("attraction", a);
        model.addAttribute("Description", service.getAttractions());
        model.addAttribute("Categories", Category.values());
        return "edit-attractions";
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
        return "redirect:/attraction/attractions";
    }
}