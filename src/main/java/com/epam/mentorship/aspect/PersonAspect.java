package com.epam.mentorship.aspect;

import com.epam.mentorship.entity.Person;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by aftor on 09.10.16.
 */
@Aspect
@Component
public class PersonAspect {
    private static final Logger logger = Logger.getLogger(PersonAspect.class);

    @Pointcut("execution(public * com.epam.mentorship.service.PersonService.insertRecord(..))")
    private void insertPersonPointcut(){}

    @Pointcut("execution(public * com.epam.mentorship.service.PersonService.updateRecord(..))")
    private void updatePersonPointcut(){}

    @Before(value = "insertPersonPointcut() && args(person)")
    public void beforeInsertPerson(Person person){
        person.setDateCreated(new Date());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null && authentication.isAuthenticated()){
            person.setCreatedByUser(authentication.getName());
        } else {
            person.setCreatedByUser("SYSTEM");
        }
    }

    @Around(value = "updatePersonPointcut() && args(person)")
    public Person aroundUpdatePerson(ProceedingJoinPoint jp, Person person) throws Throwable {
        person.setDateLastModified(new Date());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        person.setLastModifiedByUser(authentication.getName());

        Object p = jp.proceed(new Object[]{person});
        return (Person)p;
    }
}