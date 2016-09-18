package com.epam.mentorship.controller;

import com.epam.mentorship.exceptions.UpdateWithoutIdException;
import com.epam.mentorship.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by aftor on 10.09.16.
 */
@Controller
public class MainController {
    @RequestMapping(value = {"/", "index", "home"}, method = RequestMethod.GET)
    public String index() {
        return "index";
    }
}
