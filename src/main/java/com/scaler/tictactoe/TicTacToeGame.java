package com.scaler.tictactoe;

import com.scaler.tictactoe.controller.GameController;
import com.scaler.tictactoe.models.*;
import excpetions.InvalidGameBuildException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    public static void main(String[] args) throws InvalidGameBuildException {
        //System.out.println("Hello world!");
        Scanner scanner = new Scanner(System.in);
        GameController gameController = new GameController();

        System.out.println("What is the dimension of the game");
        int dimension = scanner.nextInt();

        System.out.println("Do you want to have a bot in the game ? y/n");
        String isBot = scanner.next();
        List<Player> players = new ArrayList<>();

        int numberOfPlayer = dimension - 1;
        if (isBot.charAt(0) == 'y') {
            numberOfPlayer = dimension - 2;
        }

        for (int i = 0; i < numberOfPlayer; i++) {
            System.out.println("What is the name of the player :");
            String name = scanner.next();

            System.out.println("What is the symbol of the player :");
            String symbol = scanner.next();

            players.add(new Player(name, symbol.charAt(0), PlayerType.HUMAN));
        }

        if (isBot.charAt(0) == 'y') {
            System.out.println("What is the name of the bot :");
            String name = scanner.next();

            System.out.println("What is the symbol of the bot :");
            String symbol = scanner.next();

            players.add(new Bot(name, symbol.charAt(0), PlayerType.BOT, BotDifficultyLevel.EASY));
        }

        //players list is complete.
        //Start the game.
        Game game = gameController.createGame(dimension, players);

        while (game.getGameStatus().equals(GameStatus.IN_PROGRESS)) {
            System.out.println("This is the current board: ");
            gameController.displayBoard(game);

            System.out.println("Do you want to undo ? y/n");
            String input = scanner.next();

            if (input.equals("y")) {
                gameController.undo();
            } else {
                gameController.executeNextMove(game);
            }
        }

        System.out.println("Game has ended, Result is: ");
        if (game.getGameStatus().equals(GameStatus.ENDED)) {
            System.out.println("Winner is : " + gameController.getWinner(game).getName());
        }
    }
}