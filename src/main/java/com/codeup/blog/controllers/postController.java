package com.codeup.blog.controllers;

import com.codeup.blog.models.Post;
import com.codeup.blog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class postController {
    private final PostRepository postDao;

    public postController(PostRepository postDao) {
        this.postDao = postDao;
    }

    private Iterable<Post> posts = new ArrayList<>();

    @GetMapping("/posts")
    public String Posts(Model model){
        posts = postDao.findAll();
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String Posts(@PathVariable long id, Model model){
        Post post = postDao.findOne(id);
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String showForm(){
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String create(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "body") String body
    ){
        Post post = new Post(title, body);

        postDao.save(post);

        return "redirect:/posts";

    }

    @GetMapping("/posts/{id}/edit")
    public String edit(@PathVariable long id, Model model) {
        Post post = postDao.findOne(id);
        model.addAttribute("post", post);
        return "posts/edit";

    }

    @PostMapping("/posts/{id}/edit")
    public String update(
            @PathVariable long id,
            @RequestParam(name = "title") String title,
            @RequestParam(name = "body") String body,
            Model model) {

        System.out.println("inside the update method now...");

        Post post = postDao.findOne(id);
        post.setTitle(title);
        post.setBody(body);

        postDao.save(post);

        return "redirect:/posts/" + id;
    }

    @PostMapping("/posts/delete")
    public String delete(@RequestParam(name = "id") long id) {
        Post post = postDao.findOne(id);
        postDao.delete(post);

        return "redirect:/posts";
    }


}
