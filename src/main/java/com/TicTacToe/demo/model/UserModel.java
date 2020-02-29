package com.TicTacToe.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// implemintation in the database for User object
@Entity
public class UserModel{

    @Id // states is the primary key in database
    @GeneratedValue // this automatically increments each time
    private int id;

    @Column
    private String userName;
    @Column
    private String passWord;


    public int getId(){
        return id;
    }

    public UserModel(String userName, String passWord){
        this.userName = userName;
        this.passWord = passWord;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }
    public void setPassWord(String password){
        this.passWord = password;
    }

}