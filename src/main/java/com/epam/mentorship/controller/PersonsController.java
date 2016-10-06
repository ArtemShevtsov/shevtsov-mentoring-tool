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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

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
    public ModelAndView editPersonById(@PathVariable Integer id){
        Person person = personService.getById(id);
        ModelAndView mv = getPreparedModelAndView();
        mv.addObject("person", person);
        mv.addObject("submitAction", "/persons/edit");
        return mv;
    }

    @RequestMapping(value = "/new", method = GET)
    public ModelAndView addPersonForm(){
        ModelAndView mv = getPreparedModelAndView();
        mv.addObject("person", new Person());
        mv.addObject("submitAction", "/persons/create");
        return mv;
    }

    @RequestMapping(value = "/create", method = POST)
    public ModelAndView addPerson(@Valid @ModelAttribute("person") Person newPerson, BindingResult result){
        if(result.hasErrors()){
            Map<String, Object> model = result.getModel();
            ModelAndView mv = getPreparedModelAndView();
            mv.addAllObjects(model);
            return mv;
        }
        personService.insertRecord(newPerson);
        return new ModelAndView("redirect:/persons");
    }

    @RequestMapping(value = "/edit", method = POST)
    public ModelAndView editPerson(@Valid @ModelAttribute("person") Person updPerson, BindingResult result) throws UpdateWithoutIdException {
        if(result.hasErrors()){
            Map<String, Object> model = result.getModel();
            ModelAndView mv = getPreparedModelAndView();
            mv.addAllObjects(model);
            return mv;
        } else if(updPerson.getId() == null) {
            throw new UpdateWithoutIdException(Person.class);
        }
        personService.updateRecord(updPerson);
        return new ModelAndView("redirect:/persons/" + updPerson.getId());
    }

    private ModelAndView getPreparedModelAndView(){
        ModelAndView mv = new ModelAndView("person-form");
        mv.addObject("primarySkills", PrimarySkill.values());
        mv.addObject("profLevel", ProfessionalLevel.values());
        return mv;
    }
}
