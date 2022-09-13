package com.example.TicTacToeFinal.service;

import com.example.TicTacToeFinal.model.Game;
import com.example.TicTacToeFinal.model.Player;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service

public class GameService {

    public Game createGame (Player player){

        Game game = new Game();
       game.setBoard(new int[3][3]); //Our array makes up our board (x) (y) enter 3 x 3 as these are the dimensions of the board
        game.setGameId(UUID.randomUUID().toString()); // UUID also generates random ID
        game.setPlayer1(player); // to create a game, only need player1 ID when connected to a game (to play) we can enter player2 ID.
        game.setStatus(GameStatus.NEW); // all new games have status as new

        return game; //  todo: store in sql
    }

    public Game connectTOGame(Player player2, String gameId){
        if game.getStatus 

    }
}
