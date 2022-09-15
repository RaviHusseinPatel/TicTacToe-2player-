package com.example.TicTacToeFinal.components;

import com.example.TicTacToeFinal.model.Game;
import com.example.TicTacToeFinal.model.GameStatus;
import com.example.TicTacToeFinal.model.Player;
import com.example.TicTacToeFinal.repositories.GameRepository;
import com.example.TicTacToeFinal.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    GameRepository gameRepository;

    @Autowired
    PlayerRepository playerRepository;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Player player1 = new Player("Ravi");
        Game game = new Game(player1,GameStatus.NEW);
    }


}