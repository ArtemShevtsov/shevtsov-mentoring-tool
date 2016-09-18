package com.epam.mentorship.configuration;

import com.epam.mentorship.entity.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static com.epam.mentorship.entity.OfficeLocation.*;
import static java.util.Calendar.*;
import static java.util.Calendar.SEPTEMBER;

/**
 * Created by aftor on 10.09.16.
 */
@Configuration
public class BeansConfiguration {

    @Bean
    public List<Person> listPersons(){
        List<Person> personsList = new ArrayList<>(5);
        Calendar calendar = getInstance();

        Person p1 = new Person("Ivan", "Fedorov");
        p1.setPrimarySkill(PrimarySkill.GROOVY);
        p1.setProfessionalLevel(ProfessionalLevel.L1);
        calendar.set(1994, MAY, 11);
        p1.setBirthDate(new Date(calendar.getTime().getTime()));
        p1.setManagerFullName("Oleksandr Lipsky");
        p1.setEmail("Ivan_Fedorov@epam.com");
        personsList.add(p1);

        Person p2 = new Person("Petr", "Krivonos");
        p2.setPrimarySkill(PrimarySkill.JAVA);
        p2.setProfessionalLevel(ProfessionalLevel.L2);
        calendar.set(1992, JUNE, 3);
        p2.setBirthDate(new Date(calendar.getTime().getTime()));
        p2.setManagerFullName("Yuriy Oglobyak");
        p2.setEmail("Petr_Krivonos@epam.com");
        personsList.add(p2);

        Person p3 = new Person("Andriy", "Kerchisin");
        p3.setPrimarySkill(PrimarySkill.JAVA_SCRIPT);
        p3.setProfessionalLevel(ProfessionalLevel.L4);
        calendar.set(1990, AUGUST, 22);
        p3.setBirthDate(new Date(calendar.getTime().getTime()));
        p3.setManagerFullName("Michil Fedorov");
        p3.setEmail("Andriy_Rerchisin@epam.com");
        personsList.add(p3);

        return personsList;
    }

    @Bean
    public List<MentorshipProgram> listPrograms(){
        ArrayList<MentorshipProgram> programsList = new ArrayList<>(4);
        Calendar calendar = getInstance();
        calendar.set(YEAR, 2016);

        MentorshipProgram p1 = new MentorshipProgram();
        p1.setName("Lviv MP");
        p1.setLocation(LVIV);
        calendar.set(MONTH, SEPTEMBER);
        calendar.set(DAY_OF_MONTH, 1);
        p1.setStartDate(new Date(calendar.getTime().getTime()));
        calendar.set(MONTH, NOVEMBER);
        calendar.set(DAY_OF_MONTH, 1);
        p1.setEndDate(new Date(calendar.getTime().getTime()));
        programsList.add(p1);

        MentorshipProgram p2 = new MentorshipProgram();
        p2.setName("Dnipro MP");
        p2.setLocation(DNIPRO);
        calendar.set(MONTH, SEPTEMBER);
        calendar.set(DAY_OF_MONTH, 1);
        p2.setStartDate(new Date(calendar.getTime().getTime()));
        calendar.set(MONTH, NOVEMBER);
        calendar.set(DAY_OF_MONTH, 1);
        p2.setEndDate(new Date(calendar.getTime().getTime()));
        programsList.add(p2);

        MentorshipProgram p3 = new MentorshipProgram();
        p3.setName("Kyev MP (Office 1)");
        p3.setLocation(KYEV_1);
        calendar.set(MONTH, OCTOBER);
        calendar.set(DAY_OF_MONTH, 5);
        p3.setStartDate(new Date(calendar.getTime().getTime()));
        calendar.set(MONTH, DECEMBER);
        calendar.set(DAY_OF_MONTH, 10);
        p3.setEndDate(new Date(calendar.getTime().getTime()));
        programsList.add(p3);

        MentorshipProgram p4 = new MentorshipProgram();
        p4.setName("Kyev MP (Office 2)");
        p4.setLocation(KYEV_2);
        calendar.set(MONTH, OCTOBER);
        calendar.set(DAY_OF_MONTH, 20);
        p4.setStartDate(new Date(calendar.getTime().getTime()));
        calendar.set(MONTH, DECEMBER);
        calendar.set(DAY_OF_MONTH, 31);
        p4.setEndDate(new Date(calendar.getTime().getTime()));
        programsList.add(p4);

        return programsList;
    }
}
