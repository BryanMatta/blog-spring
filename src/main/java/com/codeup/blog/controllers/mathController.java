package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class mathController {
    @GetMapping("/math/{function}/{num1}/and/{num2}")
    @ResponseBody
    public String calculator(@PathVariable String function, @PathVariable int num1, @PathVariable int num2){
        int total;
        switch (function){
            case "add":
                total = num1 + num2;
                return "The addition of " + num1 + " and " + num2 + " equals: " + total;

            case "subtract":
                total = num1 - num2;
                return "The subtraction of " + num1 + " from " + num2 + " equals: " + total;

            case "divide":
                total = num1/num2;
                return "The division of " + num1 + " by " + num2 + " equals: " + total;

            case "multiply":
                total = num1*num2;
                return "The multiplication of " + num1 + " by " + num2 + " equals: " + total;

            default:
                return "Sorry but I do not know how to do that";
        }
    }
}
