package com.epam.mentorship.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by aftor on 10.09.16.
 */
@Controller
public class HomeController {

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String index(){
        return "index";
    }
}
