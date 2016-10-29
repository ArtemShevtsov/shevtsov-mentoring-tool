package com.epam.mentorship.aspect;

import com.epam.mentorship.entity.MentorshipProgram;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by aftor on 29.10.16.
 */
@Aspect
@Component
public class MentorshipProgramAspect {

    @Pointcut("execution(com.epam.mentorship.entity.MentorshipProgram insertRecord(..))")
    private void insertRecordPointcut(){}

    @Pointcut("execution(* updateRecord(..))")
    private void updateRecordPointcut(){}

    @Pointcut("within(com.epam.mentorship.dao.MentorshipProgramDao)")
    private void withinMentorshipProgramPointcut(){}


    @Before(value = "insertRecordPointcut() && withinMentorshipProgramPointcut() && args(mentorshipProgram)")
    public void beforeInsertMentorshipProgram(MentorshipProgram mentorshipProgram){
        mentorshipProgram.setDateCreated(new Date());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null && authentication.isAuthenticated()){
            mentorshipProgram.setCreatedByUser(authentication.getName());
        } else {
            mentorshipProgram.setCreatedByUser("SYSTEM");
        }
    }

    @Before(value = "updateRecordPointcut() && withinMentorshipProgramPointcut() && args(mentorshipProgram)")
    public void aroundUpdatePerson(MentorshipProgram mentorshipProgram) throws Throwable {
        mentorshipProgram.setDateLastModified(new Date());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        mentorshipProgram.setLastModifiedByUser(authentication.getName());
    }
}
