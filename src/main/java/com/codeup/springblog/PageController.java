package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PageController {
    @GetMapping("/test")
    public String test(){
        return "test";
    }

    @GetMapping("/t")
    public String thyme(Model model){

        model.addAttribute("username", "Fred");
        return "thyme";
    }





}
