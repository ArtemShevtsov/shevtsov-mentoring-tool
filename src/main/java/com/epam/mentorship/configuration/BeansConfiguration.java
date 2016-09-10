package com.epam.mentorship.configuration;

import com.epam.mentorship.entity.Person;
import com.epam.mentorship.entity.PrimarySkill;
import com.epam.mentorship.entity.ProfessionalLevel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by aftor on 10.09.16.
 */
@Configuration
public class BeansConfiguration {

    @Bean
    public List<Person> listPersons(){
        List<Person> personsList = new ArrayList<>(5);
        Calendar calendar = Calendar.getInstance();

        Person p1 = new Person("Ivan", "Fedorov");
        p1.setPrimarySkill(PrimarySkill.GROOVY);
        p1.setProfessionalLevel(ProfessionalLevel.L1);
        calendar.set(1994, Calendar.MAY, 11);
        p1.setBirthDate(new Date(calendar.getTime().getTime()));
        p1.setManagerFullName("Oleksandr Lipsky");
        p1.setEmail("Ivan_Fedorov@epam.com");
        personsList.add(p1);

        Person p2 = new Person("Petr", "Krivonos");
        p2.setPrimarySkill(PrimarySkill.JAVA);
        p2.setProfessionalLevel(ProfessionalLevel.L2);
        calendar.set(1992, Calendar.JUNE, 3);
        p2.setBirthDate(new Date(calendar.getTime().getTime()));
        p2.setManagerFullName("Yuriy Oglobyak");
        p2.setEmail("Petr_Krivonos@epam.com");
        personsList.add(p2);

        Person p3 = new Person("Andriy", "Kerchisin");
        p3.setPrimarySkill(PrimarySkill.JAVA_SCRIPT);
        p3.setProfessionalLevel(ProfessionalLevel.L4);
        calendar.set(1990, Calendar.AUGUST, 22);
        p3.setBirthDate(new Date(calendar.getTime().getTime()));
        p3.setManagerFullName("Michil Fedorov");
        p3.setEmail("Andriy_Rerchisin@epam.com");
        personsList.add(p3);

        return personsList;
    }
}
