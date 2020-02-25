package com.TicTacToe.demo.controllers;

//import com.TicTacToe.demo.Game;
import com.TicTacToe.demo.model.GameModel;
import com.TicTacToe.demo.services.GameServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
public class GameController{
    
    @Autowired
    GameServices gameService;

    @GetMapping("/get")
    public GameModel getGame(@RequestBody int id){
        GameModel g = gameService.getGame(id);
        return g;
    }


    @PostMapping("/create")
    public int createGame(){
        int gId = gameService.createGame();
        return gId;
    }


}