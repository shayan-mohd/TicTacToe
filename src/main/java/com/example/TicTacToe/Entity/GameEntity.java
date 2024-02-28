package com.example.TicTacToe.Entity;

public class GameEntity {

    private String userOne;
    private String userTwo;

    public GameEntity(String userOne, String userTwo) {
        this.userOne = userOne;
        this.userTwo = userTwo;
    }


    public String getUserOne() {
        return userOne;
    }

    public void setUserOne(String userOne) {
        this.userOne = userOne;
    }

    public String getUserTwo() {
        return userTwo;
    }

    public void setUserTwo(String userTwo) {
        this.userTwo = userTwo;
    }
}
