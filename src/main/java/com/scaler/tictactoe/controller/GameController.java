package com.scaler.tictactoe.controller;

import com.scaler.tictactoe.models.Game;
import com.scaler.tictactoe.models.GameStatus;
import com.scaler.tictactoe.models.Player;
import excpetions.InvalidGameBuildException;

import java.util.List;

public class GameController {
    //All the functionalities required to play the game.

    public void undo() {

    }

    public Game createGame(int dimension, List<Player> players) throws InvalidGameBuildException {
        Game game = Game.getBuilder()
                        .setPlayers(players)
                        .setDimension(dimension)
                        .build();

        return game;
    }

    public void displayBoard(Game game) {
        game.displayBoard();
    }

    public GameStatus getGameStatus(Game game) {
        return game.getGameStatus();
    }

    public void executeNextMove(Game game) {
        game.makeNextMove();
    }
}
