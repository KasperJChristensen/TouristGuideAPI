package com.example.touristguideapi1.service;

import com.example.touristguideapi1.model.TouristAttraction;
import com.example.touristguideapi1.repository.TouristRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TouristService {
    private final TouristRepository repository;


    public TouristService(TouristRepository repository) {
        this.repository = repository;
    }

    public ArrayList<TouristAttraction> getAttractions(){
        return repository.getAttractions();
    }

    public TouristAttraction findAttractionByName(String name) {
        return repository.findDescriptionByName(name);
    }

    public void addAttraction(TouristAttraction attraction) {
        repository.addAttraction(attraction);
    }

    public void removeAttraction(String name){
        repository.removeAttraction(name);
    }


}
