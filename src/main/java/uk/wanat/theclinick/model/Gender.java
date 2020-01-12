package uk.wanat.theclinick.model;

public enum Gender {
    MALE("male"), FEMALE("female");

    private final String displayValue;

    private Gender(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
