package com.example.touristguideapi1.service;

import com.example.touristguideapi1.model.TouristAttraction;
import com.example.touristguideapi1.repository.TouristRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class TouristService {
    private final TouristRepository repository;


    public TouristService(TouristRepository repository) {
        this.repository = repository;
    }

    public ArrayList<TouristAttraction> getAttractions(){
        return repository.getAttractions();
    }

    public Optional<TouristAttraction> findDescriptionByName(String name, String s) {

        return Optional.ofNullable(repository.findDescriptionByName(name));
    }

    public void addAttractions(TouristAttraction attraction) {
        repository.addAttraction(attraction);
    }


}
