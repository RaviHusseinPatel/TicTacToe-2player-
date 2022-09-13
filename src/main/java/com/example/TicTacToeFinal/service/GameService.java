package com.example.TicTacToeFinal.service;

import com.example.TicTacToeFinal.model.Game;
import com.example.TicTacToeFinal.model.GameStatus;
import com.example.TicTacToeFinal.model.Player;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service

public class GameService {

    public Game createGame (Player player){
        Game game = new Game(player, GameStatus.NEW);
        //ask game repo to save
        return game;
    }

    public Game connectTOGame(Player player2, Long GameId){
        //player2 id passed in
        // find game by gameId
        //set player 2 to player 2
        // set game status = in progess
        // save game
        // return game

    }
}
