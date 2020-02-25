package com.TicTacToe.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// implemintation in the database

@Entity
public class GameModel{

    @Id // states is the primary key in database
    @GeneratedValue // this automatically increments each time
    private int id;

    @Column
    private String board; // 9 letter string that can change values for x and o

    public int getId(){
        return id;
    }

    public String getBoard(){
        return board;
    }

}