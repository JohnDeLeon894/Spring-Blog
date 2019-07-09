package com.codeup.springblog.controller;

import com.codeup.springblog.repos.PostRepo;
import com.codeup.springblog.model.User;
import com.codeup.springblog.model.Post;
import com.codeup.springblog.repos.UserRepo;
import com.codeup.springblog.service.MailSvc;
import org.apache.catalina.connector.Response;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@Controller
public class PostController {


    private final PostRepo postDao;

    private final UserRepo userDao;

    private final MailSvc emailService;

    public PostController(PostRepo postDao, UserRepo userDao, MailSvc emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
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
    public String createPostForm(Model model){
        model.addAttribute("post", new Post());
        return "post/create";
    }

    @PostMapping(path = "/post/create")
    public String insert(@ModelAttribute Post post, @RequestParam long userId ,
                         @Valid Post vPost, Errors validation, Model model)
    {
        if(validation.hasErrors()){
            model.addAttribute("erros", validation);
            model.addAttribute("post", vPost);
            return "/post/create";
        }
//        long idNum = (long)((Math.random()*299)+1);
        User user = userDao.findById(userId);
//                userDao.findById(idNum);
//        Post post= new Post(title, body,user);
        post.setOwner(user);
        postDao.save(post);
        emailService.prepareAndSend(post, "NewPost", "A new post has been created!!");
        return "redirect:/post";
    }

    @PostMapping("/post/{id}/delete")
    public String delete(@PathVariable long id) {
        Post post = postDao.findById(id);
        String msgBody = String.format("The post \"%s\" has been deleted", post.getTitle());
        emailService.prepareAndSend(post, "Post deleted",msgBody);
        postDao.delete(id);
        return "redirect:/post";
    }

    @GetMapping("/post/{id}/edit")
    public String edit(Model model, @PathVariable long id){
        Post post = postDao.findById(id);
        model.addAttribute("post", post);

        return "post/edit";
    }

    @PostMapping(path ="/post/{id}/edit")
    public String postEdit(@ModelAttribute Post post, @PathVariable long id){
        System.out.println("Post edit started");
        User user = post.getOwner();
        post.setOwner(user);
        postDao.save(post);
        String msgBody = String.format("The post \"%s\" has been edited", post.getTitle());
        emailService.prepareAndSend(post,"A post has been edited", msgBody);
        return "redirect:/post";
    }

    @GetMapping(path = "/post/mypost/{id}")
    public String viewPosts(Model model, @PathVariable long id){
        User user = userDao.findById(id);
        List<Post> postList = postDao.findAllByOwner(user);
        model.addAttribute("posts", postList);
        return "post/index";
    }

    @GetMapping(path = "/post/search")
    public String search (@RequestParam String search, Model model){
//        List<User> users = userDao.findAll();
//        List<Post> posts = postDao.findAll();
        System.out.println(search+" was passed ");
        User user = userDao.findByName(search);
        List<Post> postList = postDao.findAllByOwner(user);
        model.addAttribute("posts", postList);
        return "post/index";
    }

    @PostMapping("/post/search")
    public String postSearch (HttpServletRequest req, Model model){
        String search = req.getParameter("search");
        System.out.println(search+" was passed ");
        User user = userDao.findByName(search);
        List<Post> postList = postDao.findAllByOwner(user);
        model.addAttribute("posts", postList);

        return "post/index";
    }

    @GetMapping(value = "/servlet", headers = "X-future=automattician")

    public  String randoButton(HttpServletResponse response, HttpServletRequest request){
//        response.addHeader("X-future", "automattician");
                response.setHeader("X-future", "automattician");
        return "redirect:https://public-api.wordpress.com/wpcom/v2/work-with-us";
    }

}
