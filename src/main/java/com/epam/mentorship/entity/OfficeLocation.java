package com.epam.mentorship.entity;

/**
 * Created by aftor on 10.09.16.
 */
public enum OfficeLocation {
    LVIV("Lviv, Oleny Stepanivny, 45a"),
    KYEV_1("Kyev, First Office Adress"),
    KYEV_2("Kyev, Second Office Adress"),
    DNIPRO("Dnipro Adress");

    private final String location;

    OfficeLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return this.location;
    }

    public static OfficeLocation getFromString(String text) {
        if(text != null){
            for(OfficeLocation l: OfficeLocation.values()) {
                if(text.equals(l.location)) {
                    return l;
                }
            }
        }
        return null;
    }
}
