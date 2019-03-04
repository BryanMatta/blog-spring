package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class rollDiceController {
    @GetMapping("/roll-dice/{guess}/{tries}")
    public String guessCheck(@PathVariable int guess,@PathVariable int tries, Model model){
        int totalCorrectGuesses = 0;
        List<Integer> rolls = new ArrayList<>();
        for (int i = 0; i < tries; i++){
            int random = (int)Math.ceil(Math.random() * 6);
            rolls.add(random);
            if(random == guess){
                totalCorrectGuesses++;
            }
        }
        model.addAttribute("tries", tries);
        model.addAttribute("rolls", rolls);
        model.addAttribute("guesses", totalCorrectGuesses);
        return "dice-game";
    }
}
