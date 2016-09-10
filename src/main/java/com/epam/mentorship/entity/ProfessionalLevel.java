package com.epam.mentorship.entity;

/**
 * Created by aftor on 10.09.16.
 */
public enum ProfessionalLevel {
    L1("level_1"),
    L2("level_2"),
    L3("level_3"),
    L4("level_4"),
    L5("level_5");

    private final String level;

    ProfessionalLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return this.level;
    }

    public static ProfessionalLevel getFromString(String text) {
        if(text != null){
            for(ProfessionalLevel l: ProfessionalLevel.values()) {
                if(text.equals(l.level)) {
                    return l;
                }
            }
        }
        return null;
    }
}
