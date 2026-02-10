package com.example.touristguideapi1.model;

import java.util.List;

public class TouristAttraction {
    private String name;
    private String description;
    private String location;
    private List<Category> tags;

    public TouristAttraction(String name, String description, String location, List<Category> tags) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.tags = tags;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Category> getTags() {return tags;}

    public String getLocation() {return location;}

    public void setLocation(String location) {this.location = location;}

    public void setTags(List<Category> tags) {this.tags = tags;}
}
