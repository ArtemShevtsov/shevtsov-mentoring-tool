package com.epam.mentorship.configuration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by aftor on 08.10.16.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.inMemoryAuthentication()
                .withUser("user_1").password("pass_1").roles("USER").and()
                .withUser("user_2").password("pass_2").roles("USER").and()
                .withUser("user_3").password("pass_3").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .mvcMatchers("/persons/**", "/mentorship-programs/**").hasRole("USER")
                .and()
                .formLogin().loginProcessingUrl("/j_spring_security_check")
                .loginPage("/login").failureUrl("/login?error")
                .usernameParameter("user").passwordParameter("pass")
                .and()
                .logout().logoutUrl("/j_spring_security_logout").logoutSuccessUrl("/login?logout")
                .and()
                .csrf().disable();
    }
}
