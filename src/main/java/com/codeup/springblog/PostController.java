package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class PostController {

    /*
    *
    *  Create a PostController class. This controller should return strings for the following
    * routes that describe what will ultimately be there.
    * method	url	description
    * GET	/posts	posts index page
    * GET	/posts/{id}	view an individual post
    * GET	/posts/create	view the form for creating a post
    * POST	/posts/create	create a new post
    * */

    @GetMapping(path = "/post")
    @ResponseBody
    public String viewPost(){
        return "Posts index page";
    }

    @GetMapping(path = "/post/{id}")
    @ResponseBody
    public String viewIndiPost(@PathVariable int id){
        return "view an individual post";
    }

    @GetMapping(path = "/post/create")
    @ResponseBody
    public String createPostForm(){
        return "view the form for creating a post";
    }

    @PostMapping(path = "/post/create")
    @ResponseBody
    public String createPost(){
        return "create a new post";
    }



}
