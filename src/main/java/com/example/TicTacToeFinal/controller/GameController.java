//package com.example.TicTacToeFinal.controller;
//
//import com.example.TicTacToeFinal.model.Game;
//import com.example.TicTacToeFinal.service.GameService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping(value = "/games")
//public class GameController {
//
//    @Autowired
//    private GameService gameService;
//
//    public GameController(GameService gameService) {
//        this.gameService = gameService;
//    }
//    //    to connect a user to a game,
////    specifying the additional parameters needed in the endpoint (url)
//    @GetMapping("/{gameId}/{playerId}")
////    passing those parameters into the function below
//    public ResponseEntity<Game> connectPlayertoGame(@PathVariable Long gameId, Long playerId){
////        using the parameters to run connectToGame which requires a player id and gameid
////        this returns a game and we're saving to variable 'game'
//        Game game = gameService.connectToGame(playerId, gameId);
////        return that game to the user and send a ok response indicating the request was successful
//        return new ResponseEntity<>(game, HttpStatus.OK);
//    };
//
//    //    no parameters needed so nothing in brackets
//    @GetMapping()
//    public ResponseEntity<List<Game>> getAllGames(){
////        calling getAllGames which returns all the games as a list and we are saving to 'games'
//        List<Game> games = gameService.getAllGames();
////        return the lsit of games to the user and send a ok response indicating the request was successful
//        return new ResponseEntity<>(games, HttpStatus.OK);
//    };
//    //new method in game service to get all games available
//    public List<Game> getAllGames(){
////  calling findall method from jparepository which returns a list of games
//        return gameRepository.findAll();
//    }
//
//
//
//
//
//    // POST - new game
//    // PATCH - make move
//
//}