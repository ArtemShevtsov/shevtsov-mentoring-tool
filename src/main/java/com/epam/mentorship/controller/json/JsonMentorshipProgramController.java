package com.epam.mentorship.controller.json;

import com.epam.mentorship.entity.MentorshipProgram;
import com.epam.mentorship.service.MentorshipProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by aftor on 09.10.16.
 */
@RestController
@RequestMapping(value = "/json/mentorship-programs")
public class JsonMentorshipProgramController {
    @Autowired
    private MentorshipProgramService service;

    @RequestMapping(method = GET, produces = "application/json")
    public List<? extends MentorshipProgram> allMentorshipPrograms(){
        return service.getAll();
    }

    @RequestMapping(value="/{id}", method = GET, produces = "application/json")
    public MentorshipProgram mentroshipProgramById(@PathVariable Integer id){
        return service.getById(id);
    }
}
