package com.epam.mentorship.configuration;

import com.epam.mentorship.dao.MentorshipProgramDao;
import com.epam.mentorship.dao.PersonDao;
import com.epam.mentorship.entity.MentorshipProgram;
import com.epam.mentorship.entity.Person;
import com.epam.mentorship.repository.PersonRepository;
import org.hsqldb.util.DatabaseManagerSwing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by aftor on 11.09.16.
 */
@Configuration
public class EbeddedDataInitializer {
    @Autowired
    private PersonDao personDao;

    @Autowired
    private MentorshipProgramDao mentorshipProgramDao;

    @Autowired
    private List<Person> listPersons;

    @Autowired
    private List<MentorshipProgram> listPrograms;

    @Autowired
    private PersonRepository personRepository;

    /**
     * Here we initialize our in-memory database with data from spring context
     */
    @PostConstruct
    private void embeddedDataInitialization(){
//        for(Person p: listPersons){
//            personDao.insertRecord(p);
//        }
//
//        for(MentorshipProgram p: listPrograms){
//            mentorshipProgramDao.insertRecord(p);
//        }
//        String url = "jdbc:h2:mem:mentorship-db-jpa;DB_CLOSE_DELAY=-1;MODE=Oracle;TRACE_LEVEL_SYSTEM_OUT=2;INIT=CREATE SCHEMA IF NOT EXISTS xxx\\;SET SCHEMA xxx";
//        String url = "jdbc:hsqldb:mem:mentorship-db-jpa";
//        DatabaseManagerSwing.main(new String[] { "--url", url, "--user", "sa", "--password", "" });

//        EntityManager theManager = factory.getNativeEntityManagerFactory().createEntityManager();
//        theManager .getTransaction().begin();
        personRepository.save(listPersons.get(0));
        personRepository.save(listPersons.get(1));
//        theManager.persist(listPersons.get(0));
//        theManager.persist(listPersons.get(1));
//        theManager.getTransaction().commit();
    }
}
