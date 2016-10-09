package com.epam.mentorship.controller.json;

import com.epam.mentorship.entity.Person;
import com.epam.mentorship.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by aftor on 09.10.16.
 */
@RestController
@RequestMapping(value = "/json/persons")
public class JsonPersonController {
    @Autowired
    private PersonService personService;

    @RequestMapping(method = GET, produces = "application/json")
    public List<? extends Person> allPersons(){
        return personService.getAll();
    }

    @RequestMapping(value="/{id}", method = GET, produces = "application/json")
    public Person personById(@PathVariable Integer id){
        return personService.getById(id);
    }
}
