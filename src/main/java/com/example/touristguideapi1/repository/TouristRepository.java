package com.example.touristguideapi1.repository;

import com.example.touristguideapi1.model.Category;
import com.example.touristguideapi1.model.TouristAttraction;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {
    ArrayList<TouristAttraction> attractions = new ArrayList<>();

    public TouristRepository() {
        attractions();
    }

    // Hardkodet attraktioner //
    private void attractions() {
        attractions.add(new TouristAttraction(
                "Tivoli",
                "Med ca. 2 minutters gang fra Københavns Hovedbanegård finder du Tivoli. " +
                        "En historisk forlystelsespark grundlagt i 1843, kendt for sin stemning, " +
                        "forlystelser og verdens ældste rutsjebane.",
                "København",
                List.of(Category.CULTURE, Category.SIGHTSEEING, Category.FAMILY_FRIENDLY)
        ));

        attractions.add(new TouristAttraction(
                "Strøget",
                "Strøget starter ved Københavns Rådhusplads og strækker sig ca. 1 km gennem " +
                        "byens centrum til Kongens Nytorv. Det er en af Europas længste gågader.",
                "Rådhuspladsen – Kongens Nytorv",
                List.of(Category.CULTURE, Category.SHOPPING, Category.SIGHTSEEING)
        ));

        attractions.add(new TouristAttraction(
                "Kongens Have",
                "Kongens Have er Danmarks ældste kongelige have og ligger ved Rosenborg Slot. " +
                        "Et populært grønt åndehul med historiske omgivelser midt i København.",
                "København",
                List.of(Category.CULTURE, Category.NATURE, Category.SIGHTSEEING, Category.FAMILY_FRIENDLY)
        ));
    }

    // Metode til at kunne tilføje attraktioner //
    public void addAttraction(TouristAttraction attraction) {
        attractions.add(attraction);
    }

    public TouristAttraction removeAttraction(String name) {
        TouristAttraction attraction = findDescriptionByName(name);
        if (attraction != null) {
            attractions.remove(attraction);
        }
        return attraction;
    }

    // Metode til at retunere en attraktion //
    public ArrayList<TouristAttraction> getAttractions() {
        return attractions;
    }
    public TouristAttraction findDescriptionByName(String name) {
        for (TouristAttraction touristAttraction : attractions) {
            if (touristAttraction.getName().equalsIgnoreCase(name)) {
                return touristAttraction;
            }
        }
        return null;
    }

    // Metode til at kunne opdatere en attraktion //
    public TouristAttraction updateAttraction(TouristAttraction attraction) {
        TouristAttraction updatedAttraction = findDescriptionByName(attraction.getName());
        if (updatedAttraction != null) {
            updatedAttraction.setDescription(attraction.getDescription());
        }
        return updatedAttraction;
    }
}
