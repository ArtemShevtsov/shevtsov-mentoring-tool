package com.epam.mentorship.service;

import com.epam.mentorship.dao.PersonDao;
import com.epam.mentorship.entity.Person;
import com.epam.mentorship.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by aftor on 11.09.16.
 */
@Service
public class PersonService implements IService<Person> {
    @Autowired
    private PersonDao personDao;

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<? extends Person> getAll() {
        return personRepository.findAll();
    }

    @Override
    public Person getById(Integer id) {
        return personRepository.findOne(id);
    }

    @Override
    public Person insertRecord(Person value) {
        return personRepository.save(value);
    }

    @Override
    public Person updateRecord(Person value) {
        return personRepository.save(value);
    }
}