package com.epam.mentorship.controller;

import com.epam.mentorship.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by aftor on 10.09.16.
 */
@Controller
public class MainController {
    @Autowired
    PersonService personService;

    @RequestMapping(value={"/", "index", "home"}, method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value="persons", method = RequestMethod.GET)
    public ModelAndView allPersons(ModelAndView mv){
        mv.addObject("persons", personService.getAll());
        return mv;
    }
}
