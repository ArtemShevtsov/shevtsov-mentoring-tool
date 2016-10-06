package com.epam.mentorship.controller;

import com.epam.mentorship.entity.*;
import com.epam.mentorship.exceptions.UpdateWithoutIdException;
import com.epam.mentorship.service.MentorshipProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

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
    public ModelAndView addMentorshipProgramForm(@PathVariable Integer id){
        MentorshipProgram mentorshipProgram = service.getById(id);
        ModelAndView mv = getPreparedModelAndView();
        mv.addObject("program", mentorshipProgram);
        mv.addObject("submitAction", "/mentorship-programs/edit");
        return mv;
    }

    @RequestMapping(value = "/new", method = GET)
    public ModelAndView addMentorshipProgramForm(){
        ModelAndView mv = getPreparedModelAndView();
        mv.addObject("submitAction", "/mentorship-programs/create");
        mv.addObject("program", new MentorshipProgram());
        return mv;
    }

    @RequestMapping(value = "create", method = POST)
    public ModelAndView addMentorshipProgram(@Valid @ModelAttribute("program") MentorshipProgram mp, BindingResult result){
        if(result.hasErrors()){
            Map<String, Object> model = result.getModel();
            ModelAndView mv = getPreparedModelAndView();
            mv.addAllObjects(model);
            return mv;
        }
        service.insertRecord(mp);
        return new ModelAndView("redirect:/mentorship-programs");
    }

    @RequestMapping(value = "edit", method = POST)
    public ModelAndView editMentorshipProgram(@Valid @ModelAttribute("program") MentorshipProgram mp, BindingResult result) throws UpdateWithoutIdException {
        if(result.hasErrors()){
            Map<String, Object> model = result.getModel();
            ModelAndView mv = getPreparedModelAndView();
            mv.addAllObjects(model);
            return mv;
        } else if(mp.getId() == null) {
            throw new UpdateWithoutIdException(MentorshipProgram.class);
        }
        service.updateRecord(mp);
        return new ModelAndView("redirect:/mentorship-programs/" + mp.getId());
    }

    private ModelAndView getPreparedModelAndView(){
        ModelAndView mv = new ModelAndView("mentorship-program-form");
        mv.addObject("locations", OfficeLocation.values());
        return mv;
    }
}