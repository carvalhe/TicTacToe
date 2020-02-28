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

    public GameModel placePiece(int gameId, int x, int y){
        GameModel gm = gameRepository.getGameById(gameId);
        int pos = y*3 + x;
        String newBoard = gm.getBoard();
        // check if position is an empty spot
        if(checkMove(newBoard, pos))
        {
            // choose which piece is placed. X's always go first
            char piece = whichPiece(gameId);
            newBoard = newBoard.substring(0, pos) + piece + newBoard.substring(pos + 1);
            gm.setBoard(newBoard);
            
            gameRepository.save(gm);
            char isWinner = checkWinner(newBoard);
            if(isWinner != '-')
            {
                // found a winner, return that player
                System.out.print("Winner is Player: ");
                System.out.print(isWinner);
                gm.setBoard("---------");
            }
            else
            {
                // no winner yet, but the game can still be over
                if(gameOver(newBoard))
                {
                    System.out.printf("GameOver!!!");
                    gm.setBoard("---------");
                }
            }
        }
        else
        {
            // Invalid move, throw Error
            System.out.print("Not a Valid move. Try again"); 
        }
        return gm;
    }

    public Boolean checkMove(String board, int pos)
    {
        if(pos >= 0 && pos < 9)
            return board.charAt(pos) == '-';
        return false;
    }

    public Boolean gameOver(String board)
    {
        if(board.indexOf("-") == -1)
        {
            return true;
        }
        return false;
    }

    public Character whichPiece(int gameId)
    {
        GameModel gm = gameRepository.getGameById(gameId);
        if(gm.countX > gm.countO)
        {
            gm.countO++;
            return 'O';
        }
        gm.countX++;
        return 'X';
    }

    public Character checkWinner(String board)
    {
        // Horizontal check
        if(board.charAt(0) == board.charAt(1) && board.charAt(1) == board.charAt(2))
        {
            return board.charAt(1);
        }
        if(board.charAt(3) == board.charAt(4) && board.charAt(4) == board.charAt(5))
        {
            return board.charAt(4);
        }
        if(board.charAt(6) == board.charAt(7) && board.charAt(7) == board.charAt(8))
        {
            return board.charAt(7);
        }
        
        // Vertical check
        if(board.charAt(0) == board.charAt(3) && board.charAt(3) == board.charAt(6))
        {
            return board.charAt(3);
        }
        if(board.charAt(1) == board.charAt(4) && board.charAt(4) == board.charAt(7))
        {
            return board.charAt(4);
        }
        if(board.charAt(2) == board.charAt(5) && board.charAt(5) == board.charAt(8))
        {
            return board.charAt(5);
        }

        // Diagonal check
        if(board.charAt(0) == board.charAt(4) && board.charAt(4) == board.charAt(8))
        {
            return board.charAt(4);
        }
        if(board.charAt(2) == board.charAt(4) && board.charAt(4) == board.charAt(6))
        {
            return board.charAt(4);
        }

        return '-';
    }
}