package com.epam.mentorship.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * Created by aftor on 10.09.16.
 */
public class Person {
    private Integer id;
    @NotEmpty(message = "QQQ-WWW")
    @Size(min = 2, max = 255)
    private String firstName;
    @NotEmpty
    @Size(min = 2, max = 255)
    private String lastName;
    @NotNull
    @Past
    private Date birthDate;
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    @Size(min = 5, max = 255)
    private String managerFullName;
    @NotNull
    private ProfessionalLevel professionalLevel;
    @NotNull
    private PrimarySkill primarySkill;

    private Date dateCreated;
    private String createdByUser;
    private Date dateLastModified;
    private String lastModifiedByUser;

    public Person() {
    }

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

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getCreatedByUser() {
        return createdByUser;
    }

    public void setCreatedByUser(String createdByUser) {
        this.createdByUser = createdByUser;
    }

    public Date getDateLastModified() {
        return dateLastModified;
    }

    public void setDateLastModified(Date dateLastModified) {
        this.dateLastModified = dateLastModified;
    }

    public String getLastModifiedByUser() {
        return lastModifiedByUser;
    }

    public void setLastModifiedByUser(String lastModifiedByUser) {
        this.lastModifiedByUser = lastModifiedByUser;
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
        int result = firstName.hashCode();
        if(id != null)
            result = 31 * result + id.hashCode();
        if(lastName != null)
            result = 31 * result + lastName.hashCode();
        if(email != null)
            result = 31 * result + email.hashCode();
        if(birthDate != null)
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