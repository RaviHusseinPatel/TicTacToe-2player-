package com.example.TicTacToeFinal.model;

public class Game {

    private long id;
    private Player player1;
    private Player player2;
    private GameStatus status;
    private int [][] board; //2D array,(horizontal/vertical)
//    NOTE: This will initialize an empty board with two opening values, both 0
//    Why can't we just use X and 0 instead of 1 and 2? Because our array only takes ints
    private Counter winner; //As each game needs a winner, we'll announce our winner by their counter

    public Game(Player player1, GameStatus status) {
        this.player1 = player1;
        this.player2 = null; //can join at later time
        this.status = status;
        this.board = new int[3][3];
        this.winner = null;
    }
}
