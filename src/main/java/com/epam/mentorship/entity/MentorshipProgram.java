package com.epam.mentorship.entity;

import java.sql.Date;

/**
 * Created by aftor on 10.09.16.
 */
public class MentorshipProgram {
    private Integer id;
    private String name;
    private OfficeLocation location;
    private Date startDate;
    private Date endDate;

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
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + location.hashCode();
        result = 31 * result + startDate.hashCode();
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