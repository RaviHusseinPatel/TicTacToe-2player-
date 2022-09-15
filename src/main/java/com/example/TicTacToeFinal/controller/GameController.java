package com.example.TicTacToeFinal.controller;

import com.example.TicTacToeFinal.model.Game;
import com.example.TicTacToeFinal.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/start")
    public ResponseEntity<Game> createGame(@RequestParam Long player1Id ){
        Game game = gameService.createGame(player1Id);
        return new ResponseEntity<>(game, HttpStatus.CREATED);
    }

    //    to connect a user to a game,
//    specifying the additional parameters needed in the endpoint (url)
    @GetMapping(value = "/{gameId}/{playerId}")
//    passing those parameters into the function below
    public ResponseEntity<Game> connectToGame(@PathVariable Long gameId, @PathVariable Long playerId){
//        using the parameters to run connectToGame which requires a player id and gameid
//        this returns a game and we're saving to variable 'game'
        Game game = gameService.connectToGame(playerId, gameId);
//        return that game to the user and send a ok response indicating the request was successful
        return new ResponseEntity<>(game, HttpStatus.OK);
    };

    //makeMove
    @PatchMapping(value = "/{playerId}/{gameId}/{position}")
    public ResponseEntity<Game> makeMove (@PathVariable long playerId,@PathVariable long gameId,@PathVariable int position){
        Game game = gameService.makeMove(playerId,gameId,position);
        return new ResponseEntity<>(game,HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Game> getGameById(@PathVariable long Id){
        Optional<Game> game = gameService.GameById(Id);
        if (game.isPresent()){
            return new ResponseEntity<>(game.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }



    //    no parameters needed so nothing in brackets
//    @GetMapping()
////    public ResponseEntity<List<Game>> getAllGames(){
//////        calling getAllGames which returns all the games as a list and we are saving to 'games'
////        List<Game> games = gameService.getAllGames();
//////        return the lsit of games to the user and send a ok response indicating the request was successful
////        return new ResponseEntity<>(games, HttpStatus.OK);
////    };
//    //new method in game service to get all games available
//    public List<Game> getAllGames(){
////  calling findall method from jparepository which returns a list of games
//        return gameRepository.findAll();
//    }





    // POST - new game
    // PATCH - make move

}