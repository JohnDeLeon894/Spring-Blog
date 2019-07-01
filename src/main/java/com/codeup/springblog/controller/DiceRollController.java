package com.codeup.springblog.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DiceRollController {
    /*

     Create a page at /roll-dice that asks the user to guess a number. There should be links on
     this page for 1 through 6 that should make a get request to /roll-dice/n where n is the
     number guessed. This page should display a random number (the dice roll), the user's guess,
     and a message based on whether or not they guessed the correct number.

    Bonus

    "Roll" a series of dice on each page load,
    as opposed to an individual die. Show all the rolls to the user and display how many rolls
    matched their guess.
*/
    @GetMapping("/rolldice")
    public String rollDice(Model model){
        model.addAttribute("rolled", false);
        return "rolldice";
    }

    @GetMapping("/rolldice/{x}")

    public String rollDice(@PathVariable int x, Model model){

//        List<Integer> rolls = diceRoll(6);
        int y = diceRoll();
        model.addAttribute("rolled", true)
        .addAttribute("guess", x);
//        for (int y:rolls) {
            model.addAttribute("roll", y);

            if (y == x) {
                model.addAttribute("match", true);

               return "rolldice";

            } else {
                model.addAttribute("match", false);
                return "rolldice";
            }
//        }
    }

//  MathMethods

    private int diceRoll(){
        int die = (int)((Math.random()*5)+1);
        System.out.println("rolled "+ die);
        return die;
    }
    private List<Integer> diceRoll(int x){
        List<Integer> rolls = new ArrayList<>();
        for (int i=0;i<x;i++){
            int die= diceRoll();
            rolls.add(die);
        }
        return rolls;
    }

}
