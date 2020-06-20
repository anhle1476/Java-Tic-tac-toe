package tictactoe;

import java.util.Scanner;

public class Game {
    char[][] game = {
            {'_', '_', '_'},
            {'_', '_', '_'},
            {'_', '_', '_'}
    };
    Player player1, player2;
    GameUtils utils = new GameUtils();

    private boolean isPlaying = true;
    private int turnsCount = 0;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        printGame(game);
    }

    public void playing(Scanner scanner) {
        while (isPlaying) {
            if (turnsCount % 2 == 0) {
                player1.makeMove(game);
            } else {
                player2.makeMove(game);
            }
            printGame(game);
            String state = utils.checkState(game);
            if (state != null) {
                isPlaying = false;
                System.out.println(state);
            }
            turnsCount++;
        }
    }

    private void printGame(char[][] game) {
        System.out.println("---------");
        for (char[] row : game) {
            System.out.print("| ");
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
}