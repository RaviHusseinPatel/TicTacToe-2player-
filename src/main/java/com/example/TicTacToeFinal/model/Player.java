package com.example.TicTacToeFinal.model;

public class Player {

    private long id;

    private String username;

    public Player(String username) {
        this.username = username;
    }

public Player (){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
