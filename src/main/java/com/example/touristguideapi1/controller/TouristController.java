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
    public ResponseEntity<TouristAttraction> findAttractionByName(@PathVariable String name) {
        TouristAttraction attraction = service.findAttractionByName(name);
        if (attraction == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(attraction);

    }

    @PostMapping("/add")
    public ResponseEntity<TouristAttraction> addAttraction(@RequestBody TouristAttraction attraction) {
        service.addAttraction(attraction);
        return new ResponseEntity<>(attraction, HttpStatus.OK);
    }

    @PostMapping("/delete/{name}")
    public ResponseEntity<TouristAttraction> removeAttraction(@PathVariable String name) {
        TouristAttraction attraction = service.removeAttraction(name);
        if (attraction == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(attraction, HttpStatus.OK);
    }

    @PostMapping("/update")
    public String updatedAttraction(@ModelAttribute TouristAttraction attraction) {
        service.updatedAttraction(attraction);
        return "redirect:/attraction/attractions";
    }
}