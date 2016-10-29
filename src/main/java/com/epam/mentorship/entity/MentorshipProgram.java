package com.epam.mentorship.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by aftor on 10.09.16.
 */
public class MentorshipProgram {
    private Integer id;
    @NotEmpty
    @Size(min = 2, max = 255)
    private String name;
    @NotNull
    private OfficeLocation location;
    @NotNull
    private Date startDate;
    @NotNull
    private Date endDate;

    private Date dateCreated;
    private String createdByUser;
    private Date dateLastModified;
    private String lastModifiedByUser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OfficeLocation getLocation() {
        return location;
    }

    public void setLocation(OfficeLocation location) {
        this.location = location;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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

        MentorshipProgram that = (MentorshipProgram) o;

        if (!id.equals(that.id)) return false;
        if (!name.equals(that.name)) return false;
        if (location != that.location) return false;
        if (!startDate.equals(that.startDate)) return false;
        return endDate.equals(that.endDate);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        if(id != null)
            result = 31 * result + id.hashCode();
        if(location != null)
            result = 31 * result + location.hashCode();
        if(startDate != null)
            result = 31 * result + startDate.hashCode();
        if(endDate != null)
            result = 31 * result + endDate.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "MentorshipProgram{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location=" + location +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
