package com.example.TicTacToeFinal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @Column(name = "player1")
//    private Player player1;
//    @Column(name = "player2")
//    private Player player2;
    @Column(name = "status")
    private GameStatus status;

    @OneToMany(mappedBy = "game")
    @JsonIgnoreProperties({"game"})
    private List<Player> players;

    private ArrayList<Counter> board;
//    private int [][] board; //2D array,(horizontal/vertical)
//    NOTE: This will initialize an empty board with two opening values, both 0
//    Why can't we just use X and 0 instead of 1 and 2? Because our array only takes ints
    private Counter winner; //As each game needs a winner, we'll announce our winner by their counter

    public Game(Player player1, GameStatus status) {

        this.status = status;
        this.board = new ArrayList<Counter>(Arrays.asList(Counter.EMPTY,Counter.EMPTY,Counter.EMPTY,Counter.EMPTY,Counter.EMPTY,Counter.EMPTY,Counter.EMPTY,Counter.EMPTY,Counter.EMPTY));
        this.winner = null;
        this.players = new ArrayList<Player>();
        this.players.add(player1);
    }

    public Game (){};

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public ArrayList<Counter> getBoard() {
        return board;
    }

    public void setBoard(ArrayList<Counter> board) {
        this.board = board;
    }

    public Counter getWinner() {
        return winner;
    }

    public void setWinner(Counter winner) {
        this.winner = winner;
    }
}
