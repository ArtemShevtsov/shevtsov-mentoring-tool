package com.epam.mentorship.controller;

import com.epam.mentorship.exceptions.UpdateWithoutIdException;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Created by aftor on 18.09.16.
 */
@ControllerAdvice
public class AdviceExceptionHandler {

    @ExceptionHandler(value = UpdateWithoutIdException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ModelAndView handleException(UpdateWithoutIdException ex){
        ModelAndView mv = new ModelAndView();
        mv.addObject("errorMessage", ex.getMessage());
        mv.setViewName("update-error");
        return mv;
    }

    @InitBinder
    private void dateBinder(WebDataBinder binder) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        CustomDateEditor customDateEditor = new CustomDateEditor(simpleDateFormat, false);
        binder.registerCustomEditor(Date.class, customDateEditor);
    }
}
