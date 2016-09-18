package com.epam.mentorship.controller;

import com.epam.mentorship.entity.*;
import com.epam.mentorship.exceptions.UpdateWithoutIdException;
import com.epam.mentorship.service.MentorshipProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by aftor on 17.09.16.
 */
@Controller
@RequestMapping("/mentorship-programs")
public class MentorshipProgramController {
    @Autowired
    private MentorshipProgramService service;

    @RequestMapping(method = GET)
    public ModelAndView allMentorshipPrograms(ModelAndView mv){
        List<? extends MentorshipProgram> all = service.getAll();
        mv.addObject("programs", all);
        return mv;
    }

    @RequestMapping(value="/{id}", method = GET)
    public ModelAndView mentroshipProgramById(@PathVariable Integer id, ModelAndView mv){
        MentorshipProgram mentorshipProgram = service.getById(id);
        mv.addObject("program", mentorshipProgram);
        mv.setViewName("mentorship-program-details");
        return mv;
    }

    @RequestMapping(value = "/{id}/edit", method = GET)
    public ModelAndView addMentorshipProgramForm(@PathVariable Integer id, ModelAndView mv){
        MentorshipProgram mentorshipProgram = service.getById(id);
        mv.addObject("program", mentorshipProgram);
        mv.addObject("submitAction", "/mentorship-programs/edit");
        mv.addObject("locations", OfficeLocation.values());
        mv.setViewName("mentorship-program-form");
        return mv;
    }

    @RequestMapping(value = "/new", method = GET)
    public ModelAndView addMentorshipProgramForm(ModelAndView mv){
        mv.addObject("program", new MentorshipProgram());
        mv.addObject("submitAction", "/mentorship-programs/create");
        mv.addObject("locations", OfficeLocation.values());
        mv.setViewName("mentorship-program-form");
        return mv;
    }

    @RequestMapping(value = "create", method = POST)
    public String addMentorshipProgram(@Valid MentorshipProgram mp, BindingResult result){
        if(result.hasErrors()){
            return "mentorship-program-form";
        }
        service.insertRecord(mp);
        return "redirect:/mentorship-programs";
    }

    @RequestMapping(value = "edit", method = POST)
    public String editMentorshipProgram(@Valid MentorshipProgram mp, BindingResult result) throws UpdateWithoutIdException {
        if(result.hasErrors()){
            return "mentorship-program-form";
        } else if(mp.getId() == null) {
            throw new UpdateWithoutIdException(MentorshipProgram.class);
        }
        service.updateRecord(mp);
        return "redirect:/mentorship-programs/" + mp.getId();
    }
}
