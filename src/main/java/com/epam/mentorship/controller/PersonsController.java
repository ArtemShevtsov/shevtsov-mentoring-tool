package com.epam.mentorship.controller;

import com.epam.mentorship.entity.Person;
import com.epam.mentorship.entity.PrimarySkill;
import com.epam.mentorship.entity.ProfessionalLevel;
import com.epam.mentorship.exceptions.UpdateWithoutIdException;
import com.epam.mentorship.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by aftor on 17.09.16.
 */
@Controller
@RequestMapping(value = "/persons")
public class PersonsController {

    @Autowired
    private PersonService personService;

    @RequestMapping(method = GET)
    public ModelAndView allPersons(ModelAndView mv){
        List<? extends Person> allPersons = personService.getAll();
        mv.addObject("persons", allPersons);
        return mv;
    }

    @RequestMapping(value="/{id}", method = GET)
    public ModelAndView personById(@PathVariable Integer id, ModelAndView mv){
        Person person = personService.getById(id);
        mv.addObject("person", person);
        mv.setViewName("person-details");
        return mv;
    }

    @RequestMapping(value="/{id}/edit", method = GET)
    public ModelAndView editPersonById(@PathVariable Integer id, ModelAndView mv){
        Person person = personService.getById(id);
        mv.addObject("person", person);
        mv.addObject("submitAction", "/persons/edit");
        mv.addObject("primarySkills", PrimarySkill.values());
        mv.addObject("profLevel", ProfessionalLevel.values());
        mv.setViewName("person-form");
        return mv;
    }

    @RequestMapping(value = "/new", method = GET)
    public ModelAndView addPersonForm(ModelAndView mv){
        mv.addObject("person", new Person());
        mv.addObject("submitAction", "/persons/create");
        mv.addObject("primarySkills", PrimarySkill.values());
        mv.addObject("profLevel", ProfessionalLevel.values());
        mv.setViewName("person-form");
        return mv;
    }

    @RequestMapping(value = "/create", method = POST)
    public String addPerson(@Valid Person newPerson, BindingResult result){
        if(result.hasErrors()){
            return "person-form";
        }
        personService.insertRecord(newPerson);
        return "redirect:/persons";
    }

    @RequestMapping(value = "/edit", method = POST)
    public String editPerson(@Valid Person updPerson, BindingResult result) throws UpdateWithoutIdException {
        if(result.hasErrors()){
            return "person-form";
        } else if(updPerson.getId() == null) {
            throw new UpdateWithoutIdException(Person.class);
        }
        personService.updateRecord(updPerson);
        return "redirect:/persons/" + updPerson.getId();
    }

//    @ExceptionHandler(value = UpdateWithoutIdException.class)
//    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
//    public ModelAndView handleException(UpdateWithoutIdException ex){
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("errorMessage", ex.getMessage());
//        mv.setViewName("update-error");
//        return mv;
//    }
}
