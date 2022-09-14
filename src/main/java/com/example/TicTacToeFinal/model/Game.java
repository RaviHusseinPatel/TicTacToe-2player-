package com.example.TicTacToeFinal.model;

import java.util.ArrayList;
import java.util.Arrays;

public class Game {

    private long id;
    private Player player1;
    private Player player2;
    private GameStatus status;

    private ArrayList<Counter> board;
//    private int [][] board; //2D array,(horizontal/vertical)
//    NOTE: This will initialize an empty board with two opening values, both 0
//    Why can't we just use X and 0 instead of 1 and 2? Because our array only takes ints
    private Counter winner; //As each game needs a winner, we'll announce our winner by their counter

    public Game(Player player1, GameStatus status) {
        this.player1 = player1;
        this.player2 = null; //can join at later time
        this.status = status;
        this.board = new ArrayList<Counter>(Arrays.asList(Counter.EMPTY,Counter.EMPTY,Counter.EMPTY,Counter.EMPTY,Counter.EMPTY,Counter.EMPTY,Counter.EMPTY,Counter.EMPTY,Counter.EMPTY));
        this.winner = null;
    }

    public Game (){};

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
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
