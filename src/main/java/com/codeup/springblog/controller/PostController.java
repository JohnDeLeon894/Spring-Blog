package com.codeup.springblog.controller;

import com.codeup.springblog.repos.PostRepo;
import com.codeup.springblog.model.User;
import com.codeup.springblog.model.Post;
import com.codeup.springblog.repos.UserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {


    private final PostRepo postDao;

    private final UserRepo userDao;

    public PostController (PostRepo postDao, UserRepo userDao){
        this.postDao = postDao;
        this.userDao = userDao;
    }


    public static void main(String[] args) {

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

        User user =   post.getOwner();
        model.addAttribute("post", post);
        model.addAttribute("user", user);

        return "post/show";
    }

    @GetMapping(path = "/post/create")
    public String createPostForm(){
        return "post/create";
    }

    @PostMapping(path = "/post/create")

    public String insert(
        @RequestParam String title,
        @RequestParam String body){
        long idNum = (long)((Math.random()*299)+1);
        User user = userDao.findById(idNum);
        Post post= new Post(title, body,user);
        post.setOwner(user);
        postDao.save(post);
        return "redirect:/post";
    }

    @PostMapping("/post/{id}/delete")
    public String delete(@PathVariable long id) {
        postDao.delete(id);
        return "redirect:/post";
    }

}
