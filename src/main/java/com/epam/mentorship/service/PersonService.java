package com.epam.mentorship.service;

import com.epam.mentorship.dao.PersonDao;
import com.epam.mentorship.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by aftor on 11.09.16.
 */
@Component
public class PersonService implements IService<Person> {
    @Autowired
    private PersonDao personDao;

    @Override
    public List<? extends Person> getAll() {
        return personDao.getAll();
    }

    @Override
    public Person getById(Integer id) {
        return personDao.getById(id);
    }

    @Override
    public Person insertRecord(Person value) {
        return personDao.insertRecord(value);
    }

    @Override
    public Person updateRecord(Person value) {
        return personDao.updateRecord(value);
    }
}