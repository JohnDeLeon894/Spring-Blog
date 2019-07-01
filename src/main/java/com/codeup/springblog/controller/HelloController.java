package com.codeup.springblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {
    @GetMapping(path = "/hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }

    @GetMapping("/goodbye")
    @ResponseBody
    public String goodBye(){
        return "Goodbye";
    }

    // path variables

    @GetMapping("/hello/{name}")
    @ResponseBody
    public String helloName(@PathVariable String name){
        return "hello "+ name + "!";
    }

    @GetMapping("/favenum/{num}")
    @ResponseBody
    public String helloName(@PathVariable int num){
        return "Fave Num is "+ num + "!";
    }

    @RequestMapping(path = "/increment/{number}" , method = RequestMethod.GET)
    @ResponseBody
    public String addOne(@PathVariable int number) {
        return number +" plus 1 is " + (number+1);
    }

}
