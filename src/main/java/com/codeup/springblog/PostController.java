package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    private final PostRepo postDao;

    public PostController (PostRepo postDao){
        this.postDao = postDao;
    }

    @GetMapping(path = "/post")
    public String viewPosts(Model model){
        List<Post> postList = postDao.findAll();
        model.addAttribute("posts", postList);
        return "post/index";
    }

    @GetMapping(path = "/post/{id}")
    public String viewIndiPost(@PathVariable long id, Model model){

//        List<Post> posts = postList();
//        Post post = posts.get(id-1);
        Post post = postDao.findById(id);
        model.addAttribute("post", post);

        return "post/show";
    }

//    private List<Post> postList(){
//
//        List<Post> posts = new ArrayList<> ();
//
//        Post post1 = new Post("Post 1", "Some nerdy things about nerdy people.");
//        Post post2 = new Post("Post 2", "Other nerdy things about nerdy stuff.");
//
//        posts.add(post1);
//        posts.add(post2);
//
//        return posts;
//    }

    @GetMapping(path = "/post/create")

    public String createPostForm(){
        return "post/create";
    }

    @PostMapping(path = "/post/create")
    @RequestMapping
    public String createPost(){
        return "post/show";
    }



}
