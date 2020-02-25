package com.TicTacToe.demo.services;

import com.TicTacToe.demo.Repository.GameRepository;
import com.TicTacToe.demo.model.GameModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Business logic for the game.

@Service
public class GameServices{
    
    @Autowired
    GameRepository gameRepository;

    public GameModel getGame(int id){
        return gameRepository.getGameById(id);
    }

    public int createGame(){
        GameModel g = new GameModel();
        GameModel savedGame = gameRepository.save(g);

        return savedGame.getId();
    }
}