package com.epam.mentorship.configuration;

import com.epam.mentorship.dao.PersonDao;
import com.epam.mentorship.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by aftor on 11.09.16.
 */
@Configuration
public class EbeddedDataInitializer {
    @Autowired
    PersonDao personDao;

    @Autowired
    private List<Person> listPersons;

    /**
     * Here we initialize our in-memory database with data from spring context
     */
    @PostConstruct
    private void embeddedDataInitialization(){
        for(Person p: listPersons){
            personDao.insertRecord(p);
        }
    }
}
