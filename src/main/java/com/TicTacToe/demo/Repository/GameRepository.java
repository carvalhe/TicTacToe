package com.TicTacToe.demo.Repository;

import com.TicTacToe.demo.model.GameModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Access the Database, save and get from it as well

@Repository
public interface GameRepository extends JpaRepository<GameModel, Integer>{

    public GameModel getGameById(int id);
}