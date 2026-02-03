package com.example.touristguideapi1.repository;

import com.example.touristguideapi1.model.TouristAttraction;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;

@Repository
public class TouristRepository {
    ArrayList<TouristAttraction> attractions = new ArrayList<>();

    public TouristRepository() {
        attractions();
    }

    private void attractions() {
        attractions.add(new TouristAttraction("Tivoli",
                "Med ca. 2 minutters gågang fra Københavnshovedbanegård finder du Tivoli. " +
                        "Et historisk forlystelses park, der blev grundlagt i 1843 og har verdens ældste rutsjebane"
        ));
        attractions.add(new TouristAttraction("Strøget",
                "Strøget starter foran København Rådhus og strækker sig ca. 1km igennem det centrale København til Kongens Nytorv"));
    }

    public void addAttraction(TouristAttraction attraction) {
        attractions.add(attraction);
    }

    public TouristAttraction removeAttraction(String name) {
        TouristAttraction attraction = findDescriptionByName(name);
        attractions.remove(attraction);
        return attraction;
    }

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

    public TouristAttraction updateAttraction(TouristAttraction attraction) {
        for (TouristAttraction attraction1 : attractions) {
            if (attraction1.getName().equalsIgnoreCase(attraction.getName())) {
                attraction1.setDescription(attraction.getDescription());
                return attraction1;
            }

        }
        return null;
    }
}
