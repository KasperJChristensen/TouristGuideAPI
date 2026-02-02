package com.example.touristguideapi1.controller;

import com.example.touristguideapi1.model.TouristAttraction;
import com.example.touristguideapi1.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping("attractions")
public class TouristController {
    private final TouristService service;

    public TouristController(TouristService touristService) {
        this.service = touristService;
    }

    @GetMapping
    public ResponseEntity<ArrayList<TouristAttraction>> getAttractions() {
        ArrayList<TouristAttraction> attractions = service.getAttractions();
        return ResponseEntity.ok(attractions);
    }

    @GetMapping("/{name}")
    public ResponseEntity<TouristAttraction> findDescriptionByName(@PathVariable String name) {
        Optional<TouristAttraction> attraction = service.findDescriptionByName(name);
        if (attraction.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(attraction.get());

    }
    @PostMapping("/add")

    public ResponseEntity<TouristAttraction> addAttraction(@RequestBody TouristAttraction attraction) {
        service.addAttractions(attraction);
        return new ResponseEntity<>(attraction, HttpStatus.OK);
    }
}