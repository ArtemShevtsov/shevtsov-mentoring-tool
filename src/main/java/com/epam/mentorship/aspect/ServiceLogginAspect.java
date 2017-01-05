package com.epam.mentorship.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by aftor on 29.10.16.
 */
@Aspect
@Component
public class ServiceLogginAspect {
    private static final Logger logger = Logger.getLogger(ServiceLogginAspect.class);

    @Pointcut("within(com.epam.mentorship.service.*)")
    private void anyMethodFromServicePackage(){}

    @Before(value = "anyMethodFromServicePackage()")
    public void beforeDaoMethodLogging(JoinPoint jp){
        StringBuilder stringBuilder = new StringBuilder();
        Object[] args = jp.getArgs();
        stringBuilder.append(String.format("BEFORE EXECUTION METHOD %s.\n\t\tSignature: %s",
                jp.getSignature().getName(),
                jp.getSignature()
        ));

        if(args.length > 0){
            stringBuilder.append("\n\t\tParams: ");
            for(int i = 0; i < args.length; i++){
                stringBuilder.append(String.format("\n\t\t\t Class: %s, toString: \n%s",
                        args[i].getClass().toString(),
                        args[i].toString()
                ));
            }
            stringBuilder.append("\n");
        }

        logger.info(stringBuilder.toString());
    }
}
