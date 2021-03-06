package com.TicTacToe.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// implemintation in the database for Game Object

@Entity
public class GameModel{

    @Id // states is the primary key in database
    @GeneratedValue // this automatically increments each time
    private int id;

    public int countX = 0;
    public int countO = 0;

    @Column
    private String board; // 9 letter string that can change values for x and o

    public int getId(){
        return id;
    }

    public String getBoard(){
        return board;
    }

    public void setBoard(String s){
        this.board = s;
    }

    /*
    public int getCountX(){
        return countX;
    }
    public int getCountO(){
        return countO;
    }
    */
    
}