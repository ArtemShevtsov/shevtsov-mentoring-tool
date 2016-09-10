package com.epam.mentorship.entity;

/**
 * Created by aftor on 10.09.16.
 */
public enum PrimarySkill {
    JAVA("Java"),
    GROOVY("Groovy"),
    JAVA_SCRIPT("JavaScript");

    private final String skill;

    PrimarySkill(String skill) {
        this.skill = skill;
    }


    @Override
    public String toString() {
        return this.skill;
    }

    public static PrimarySkill getFromString(String text) {
        if(text != null){
            for(PrimarySkill s: PrimarySkill.values()) {
                if(text.equals(s.skill)) {
                    return s;
                }
            }
        }
        return null;
    }
}
