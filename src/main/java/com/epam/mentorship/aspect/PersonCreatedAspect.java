package com.epam.mentorship.aspect;

import com.epam.mentorship.entity.Person;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by aftor on 09.10.16.
 */
@Aspect
@Component
public class PersonCreatedAspect {
    /**
     * if use com.epam.mentorship.dao.PersonDao.insertRecord (full method signature)
     * then I get exception on initialization Bean (proxy problem)
     */
//    @Pointcut(
//    "execution(public com.epam.mentorship.entity.Person com.epam.mentorship.dao.PersonDao.insertRecord(com.epam.mentorship.entity.Person))"
//    )
//    private void insertPerson(){}
//
//    @Before(value = "insertPerson()", argNames = "person")
//    public void insertPerson(Person person){
//        person.getFirstName();
//    }


    /**
     * In some reasons aspects do not work
     * configuration in WebAppConfiguration and aspect.AspectConfiguration
    */
    @Pointcut("execution(* *.PersonDao.insertRecord(com.epam.mentorship.entity.Person))")
    private void insertPersonPointcut(){}

    @Pointcut("execution(public * *.PersonService.getById(..))")
    private void getByIdPointcut(){}

    @Before(value = "insertPersonPointcut()")
    public void beforeInsertPerson(){
        System.out.println("I am in ASPECT (beforeInsertPerson)!!!");
    }

    @AfterReturning(pointcut = "getByIdPointcut()", returning = "person")
    public void afterGetByNameCount(Object person){
        System.out.println("I am in ASPECT (afterGetByNameCount)!!!");
//        Person p = (Person)person;
    }
}