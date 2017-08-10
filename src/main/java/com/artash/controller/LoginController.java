package com.artash.controller;


import com.artash.data.entity.User;
import com.artash.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.StringWriter;


@RestController
public class LoginController {

    @Autowired
    private  MyUserDetailsService userService;

    @Autowired
    public LoginController(MyUserDetailsService userService) {
        this.userService = userService;
    }


    @RequestMapping(value = "/registration",method = RequestMethod.POST)
    public String createNewUser(@RequestBody User user) {
        userService.save(user);
        return "ok";
    }


//    @RequestMapping(value = "/login",method = RequestMethod.POST)
//    public boolean sendAuth() {
//        return SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
//    }


    @RequestMapping(value = {"/","/login"}, method = RequestMethod.GET)
    public ModelAndView loginPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }


    @RequestMapping(value = {"/test"}, method = RequestMethod.GET)
    public String test() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails user = userService.loadUserByUsername(auth.getName());
        return "ok";
    }

}
