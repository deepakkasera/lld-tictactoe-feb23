package com.scaler.tictactoe.models;

import excpetions.InvalidGameBuildException;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private GameStatus gameStatus;
    private int nextPlayerIndex;

    public static Builder getBuilder() {
        return new Builder();
    }
    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public void displayBoard() {
        this.board.display();
    }

    public void makeNextMove() {
        Player playerToMove = players.get(nextPlayerIndex);

        System.out.println("It is " + playerToMove.getName() + "'s turn to play");

        Move move = playerToMove.decideMove(this.board);

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        System.out.println("Player is making a move at row: " + row + " & col: " + col);

        //Game will validate the move. -> TODO.

        board.getBoard().get(row).get(col).setPlayer(playerToMove);
        board.getBoard().get(row).get(col).setCellState(CellState.FILLED);

        nextPlayerIndex = (nextPlayerIndex+1) % players.size();

        // Winning Strategy.

    }

    public static class Builder {
        private int dimension;
        private List<Player> players;

        public int getDimension() {
            return dimension;
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public List<Player> getPlayers() {
            return players;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        private boolean isValid() {
            //validation
            if (dimension < 3) {
                return false;
            }

            if (players.size() != dimension - 1) {
                return false;
            }

            //TODO
            return true;
        }

        public Game build() throws InvalidGameBuildException {
            //validate the Game before creating it.
            if (!isValid()) {
                throw new InvalidGameBuildException("Some wrong input passed");
            }

            Game game = new Game();
            game.setGameStatus(GameStatus.IN_PROGRESS);
            game.setBoard(new Board(dimension));
            game.setPlayers(new ArrayList<>());
            game.setMoves(new ArrayList<>());
            game.setNextPlayerIndex(0);
            return game;
        }
    }
}
