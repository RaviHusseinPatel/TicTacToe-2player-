package com.example.TicTacToeFinal.controller;

import com.example.TicTacToeFinal.model.Game;
import com.example.TicTacToeFinal.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    GameService gameService;

//    @GetMapping
//    public ResponseEntity<List<Game>> getAllGames(
//
//    )

    // POST - new game
    // PATCH - make move 

}
