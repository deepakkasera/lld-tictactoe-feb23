package com.scaler.tictactoe;

import com.scaler.tictactoe.models.Bot;
import com.scaler.tictactoe.models.BotDifficultyLevel;
import com.scaler.tictactoe.models.Player;
import com.scaler.tictactoe.models.PlayerType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    public static void main(String[] args) {
        //System.out.println("Hello world!");
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is the dimension of the game");
        int dimension = scanner.nextInt();

        System.out.println("Do you want to have a bot in the game ? y/n");
        String isBot = scanner.nextLine();
        List<Player> players = new ArrayList<>();

        int numberOfPlayer = dimension - 1;
        if (isBot.charAt(0) == 'y') {
            numberOfPlayer = dimension - 2;
        }

        for (int i = 0; i < numberOfPlayer; i++) {
            System.out.println("What is the name of the player :");
            String name = scanner.nextLine();

            System.out.println("What is the symbol of the player :");
            String symbol = scanner.nextLine();

            players.add(new Player(name, symbol.charAt(0), PlayerType.HUMAN));
        }

        if (isBot.charAt(0) == 'y') {
            System.out.println("What is the name of the bot :");
            String name = scanner.nextLine();

            System.out.println("What is the symbol of the bot :");
            String symbol = scanner.nextLine();

            players.add(new Bot(name, symbol.charAt(0), PlayerType.BOT, BotDifficultyLevel.EASY));
        }

        //Insert the bot in the players.
    }
}