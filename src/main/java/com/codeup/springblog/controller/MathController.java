package com.codeup.springblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    /*
    template
    @GetMapping(path = "/ ")
    @ResponseBody
    public String methodname(){
        return null;
    }
    */


    @GetMapping(path = "/add/{x}/and/{y}")
    @ResponseBody
    public String add(@PathVariable int x,@PathVariable int y){
        int n = x+y;
        return String.format("%d plus %d = %d", x, y, n);

    }

    @GetMapping(path = "/sub/{x}/and/{y}")
    @ResponseBody
    public String subtract(@PathVariable int x,@PathVariable int y){
        int n = x - y;
        return String.format("%d minus %d = %d", x, y, n);
    }

    @GetMapping(path = "/multiply/{x}/and/{y}")
    @ResponseBody
    public String multi(@PathVariable int x,@PathVariable int y){
        int n = x*y;
        return  String.format("%d times %d = %d", x, y, n);
    }

    @GetMapping(path = "/divide/{x}/and/{y}")
    @ResponseBody
    public String divide(@PathVariable int x,@PathVariable int y){
        int n = x/y;
        return  String.format("%d divided by %d = %d", x, y, n);
    }

}
