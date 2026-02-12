package com.example.pokerwebapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pokerlogic.Poker; // import your logic

@RestController
public class PokerController {

    @GetMapping("/play")
    public String playGame() {
        // This will run your poker logic
        return Poker.playGame();  // you’ll replace this soon with cleaner code

    }
}