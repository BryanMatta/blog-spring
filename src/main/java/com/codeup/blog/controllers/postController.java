package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class postController {
    @GetMapping("/posts")
    @ResponseBody
    public String Posts(){
        String Title = "<h1>Here are all the posts</h1>\n";
        String postTitle;
        String postBody;
        String cardInit = "<div>\n";
        String cardEnd = "</div>\n";
        String Post = "";
        for(int i = 0; i<5;i++){
            postTitle = "<h1>Post# " + i + "</h1>\n";
            postBody = "<p>Description for post# " + i + "</p>\n";
            Post += cardInit + postTitle + postBody + cardEnd;
        }
        return Title + Post;
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String Posts(@PathVariable int id){
        String postTitle = "<h1>Post# " + id + "</h1>\n";
        String postBody = "<p>Description for post# " + id + "</p>\n";
        String cardInit = "<div>\n";
        String cardEnd = "</div>\n";
        String Post = cardInit + postTitle + postBody + cardEnd;

        return Post;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String form(){
        String form = "<form >";
        return form;
    }
}
