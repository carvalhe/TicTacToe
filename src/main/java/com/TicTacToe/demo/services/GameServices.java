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
        //GameModel gm = GameModel.builder().game("---------").build();
        GameModel gm = new GameModel();
        gm.setBoard("---------");
        GameModel savedGame = gameRepository.save(gm);

        return savedGame.getId();
    }

    public GameModel placePiece(int gameId, String piece, int x, int y){
        GameModel gm = gameRepository.getGameById(gameId);
        int pos = y*3 + x;
        String newBoard = gm.getBoard();
        newBoard = newBoard.substring(0, pos) + piece + newBoard.substring(pos);
        gm.setBoard(newBoard);
        
        gameRepository.save(gm);
        return gm;
    }

}