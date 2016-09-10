package com.epam.mentorship.entity;

import java.sql.Date;

/**
 * Created by aftor on 10.09.16.
 */
public class Person {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private Date birthDate;
    private String managerFullName;
    private ProfessionalLevel professionalLevel;
    private PrimarySkill primarySkill;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getManagerFullName() {
        return managerFullName;
    }

    public void setManagerFullName(String managerFullName) {
        this.managerFullName = managerFullName;
    }

    public ProfessionalLevel getProfessionalLevel() {
        return professionalLevel;
    }

    public void setProfessionalLevel(ProfessionalLevel professionalLevel) {
        this.professionalLevel = professionalLevel;
    }

    public PrimarySkill getPrimarySkill() {
        return primarySkill;
    }

    public void setPrimarySkill(PrimarySkill primarySkill) {
        this.primarySkill = primarySkill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (!id.equals(person.id)) return false;
        if (!firstName.equals(person.firstName)) return false;
        if (!lastName.equals(person.lastName)) return false;
        if (!email.equals(person.email)) return false;
        return birthDate.equals(person.birthDate);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + birthDate.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", managerFullName=" + managerFullName +
                ", professionalLevel=" + professionalLevel +
                ", primarySkill=" + primarySkill +
                '}';
    }
}
