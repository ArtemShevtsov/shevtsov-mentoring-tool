package com.epam.mentorship.configuration;

import com.epam.mentorship.dao.MentorshipProgramDao;
import com.epam.mentorship.dao.PersonDao;
import com.epam.mentorship.entity.MentorshipProgram;
import com.epam.mentorship.entity.Person;
import org.hsqldb.util.DatabaseManagerSwing;
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
    private PersonDao personDao;

    @Autowired
    private MentorshipProgramDao mentorshipProgramDao;

    @Autowired
    private List<Person> listPersons;

    @Autowired
    private List<MentorshipProgram> listPrograms;

    /**
     * Here we initialize our in-memory database with data from spring context
     */
    @PostConstruct
    private void embeddedDataInitialization(){
        for(Person p: listPersons){
            personDao.insertRecord(p);
        }

        for(MentorshipProgram p: listPrograms){
            mentorshipProgramDao.insertRecord(p);
        }

//        DatabaseManagerSwing.main(new String[] { "--url", "jdbc:h2:mem:mentorship-db", "--user", "sa", "--password", "" });
    }
}
