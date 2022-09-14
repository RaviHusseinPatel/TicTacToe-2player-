package com.example.TicTacToeFinal.service;

import com.example.TicTacToeFinal.model.Counter;
import com.example.TicTacToeFinal.model.Game;
import com.example.TicTacToeFinal.model.GameStatus;
import com.example.TicTacToeFinal.model.Player;
import com.example.TicTacToeFinal.repositories.GameRepository;
import com.example.TicTacToeFinal.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service

public class GameService {
    @Autowired
    GameRepository gameRepository;
    @Autowired
    PlayerRepository playerRepository;

    private ArrayList<Integer> playedMoves = new ArrayList<>();

    private int current;
    public Game createGame (long player1id ){  //~do we pass in our own game id or is it created for us?
        Player player1= playerRepository.findById(player1id).get();
        Game game = new Game(player1, GameStatus.NEW);
        gameRepository.save(game);
        //ask game repo to save
        return game;
    }

    public Game connectTOGame(long player2id, Long gameId){
        //player2 id passed in
        Player player2= playerRepository.findById(player2id).get();
        // find game by gameId
        Game game = gameRepository.findById(gameId).get();
        //set player 2 to player 2
        game.setPlayer2(player2);
        //Connect board
        ArrayList<Counter> board= new ArrayList<Counter>();
        // set game status = in progess
        game.setStatus(GameStatus.ONGOING);
        // save game
        gameRepository.save(game);
        // return game
        return game;
// TODO: Make connect to game method
    }

    public Game makeMove (long playerId, long gameId, int position){
    //Player 1 is given X, 2 O
        Player player= playerRepository.findById(playerId).get();
        Game game = gameRepository.findById(gameId).get();
        if (player.getId()==game.getPlayer1().getId()){
            game.getBoard().set(position, Counter.X);
        }
        else if (player.getId()==game.getPlayer2().getId()){
            game.getBoard().set(position, Counter.O);
        }

//        ELSE THROW EXCEPTION (EXTENSION)
//        check win method
        gameRepository.save(game);
        return game;

    };

    public Counter checkwinner(Game game);
    //top of file we need a private static final: list of winning combinations
}
