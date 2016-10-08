package com.epam.mentorship.controller;

import com.epam.mentorship.exceptions.UpdateWithoutIdException;
import com.epam.mentorship.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout,
            ModelAndView mv){
        if(error != null) {
            mv.addObject("error", "Wrong username or password");
        }

        if(logout != null) {
            mv.addObject("msg", "You logged out succesfully");
        }
        mv.setViewName("login");
        return mv;
    }
}
