package com.example.react_Spring.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    protected void configure(HttpSecurity http) throws Exception{
       // http.csrf().disable();
       // http.authorizeRequests()
     //           .antMatchers("/**").permitAll()
       //         .antMatchers("/AUTH").hasRole("USER");
    }
}
