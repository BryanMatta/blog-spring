package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class helloController {
    @GetMapping("/hello/{name}/{age}")
    @ResponseBody
    public String hello(@PathVariable String name, @PathVariable int age){
        return "Hello " + name + "<br>You are: " + age + " years of age!";
    }
    @GetMapping("/hello/{name}")
    @ResponseBody
    public String hello(@PathVariable String name){
        return "Hello from " + name;
    }
    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello from Spring";
    }
}
