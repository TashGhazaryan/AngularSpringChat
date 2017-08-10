package com.artash.controller;

import com.artash.data.entity.User;
import com.artash.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private  MyUserDetailsService userService;


    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public List<User> authLogin() {
        return userService.getAllUsers();
    }
}
