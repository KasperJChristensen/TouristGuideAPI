package com.example.touristguideapi1.model;

public enum Category {
    CULTURE("Culture"),
    SIGHTSEEING("Sightseeing"),
    SHOPPING("Shopping"),
    NATURE("Nature"),
    FAMILY_FRIENDLY("Family Friendly"),
    HISTORY("History");

    private final String displayName;

    Category(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}