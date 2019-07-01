package com.codeup.springblog.controller;

import com.codeup.springblog.repos.UserRepo;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private final UserRepo userDao;

    public UserController(UserRepo userDao) {
        this.userDao = userDao;
    }
}
