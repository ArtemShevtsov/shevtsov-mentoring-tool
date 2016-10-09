package com.epam.mentorship.configuration.web;

import com.epam.mentorship.configuration.aspect.AspectConfiguration;
import com.epam.mentorship.configuration.security.SecurityConfiguration;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by aftor on 10.09.16.
 */

@Configuration
@EnableWebMvc
@ComponentScan({
        "com.epam.mentorship.configuration",
        "com.epam.mentorship.controller",
        "com.epam.mentorship.dao",
        "com.epam.mentorship.service",
        "com.epam.mentorship.aspect"
})
public class WebAppConfiguration extends WebMvcConfigurerAdapter {
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");

        return resolver;
    }
}
