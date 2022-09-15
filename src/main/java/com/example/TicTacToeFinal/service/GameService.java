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
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service

public class GameService {
    @Autowired
    GameRepository gameRepository;
    @Autowired
    PlayerRepository playerRepository;

    private static final int[][] winCombinations = new int[][]{
            {0,1,2}, {3,4,5}, {6,7,8},
            {0,3,6}, {1,4,7}, {2,5,8},
            {0,4,8}, {2,4,6}
    }; //array of integer arrays [][]

    public Game createGame (long player1id ){  //~do we pass in our own game id or is it created for us?
        Player player1= playerRepository.findById(player1id).get();
        Game game = new Game(player1, GameStatus.NEW);
        gameRepository.save(game);
        //ask game repo to save
        return game;
    }

    public Game connectToGame(long player2id, Long gameId){
        //player2 id passed in
        Player player2= playerRepository.findById(player2id).get();
        // find game by gameId
        Game game = gameRepository.findById(gameId).get();
        //set player 2 to player 2
       game.getPlayers().add(player2);
//        Connect board
//        ArrayList<Counter> board= new ArrayList<Counter>();
//        set game status = in progess
        game.setStatus(GameStatus.ONGOING);
        // save game
        gameRepository.save(game);
        // return game
        return game;
    }

    public Game makeMove (long playerId, long gameId, int position){
    //Player 1 is given X, 2 O

        Game game = gameRepository.findById(gameId).get();
        if (playerId == 0){
            game.getBoard().set(position, Counter.X);
        }
        else if (playerId == 1){
            game.getBoard().set(position, Counter.O);
        }
//        ELSE THROW EXCEPTION (EXTENSION)
//        check win method
        game.setWinner(checkWinner(game));
        gameRepository.save(game);
        return game;
    };

    public Counter checkWinner(Game game) {
        for (int i = 0; i < winCombinations.length; i++) { //loop through outer array for all win combos
            if (
                    game.getBoard().get(winCombinations[i][0]).equals(Counter.EMPTY) || //will check for empty
                            game.getBoard().get(winCombinations[i][1]).equals(Counter.EMPTY) ||
                            game.getBoard().get(winCombinations[i][2]).equals(Counter.EMPTY)
            ) {
                return null;
            }
            if (
                    game.getBoard().get(winCombinations[i][0]).equals(game.getBoard().get(winCombinations[i][1])) &&
                            game.getBoard().get(winCombinations[i][1]).equals(game.getBoard().get(winCombinations[i][2]))
            ) {
                return game.getBoard().get(winCombinations[i][0]); //return counter EMUN type
            }
        }
        return null;
    }
    //new method in game service to get all games available
    public List<Game> getAllGames(){
//  calling findall method from jparepository which returns a list of games
        return gameRepository.findAll();
    }

    public Optional<Game> GameById(long Id){
        return gameRepository.findById(Id);
    }

}
