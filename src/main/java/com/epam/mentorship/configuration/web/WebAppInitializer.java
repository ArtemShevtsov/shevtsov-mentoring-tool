package com.epam.mentorship.configuration.web;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by aftor on 10.09.16.
 */
public class WebAppInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext annotationConfigWebApplicationContext = new AnnotationConfigWebApplicationContext();
        annotationConfigWebApplicationContext.register(WebAppConfiguration.class);

        ServletRegistration.Dynamic dispatcherServlet
                = servletContext.addServlet("dispatcher-servlet", new DispatcherServlet(annotationConfigWebApplicationContext));
        dispatcherServlet.addMapping("/");
        dispatcherServlet.setLoadOnStartup(1);
    }
}
