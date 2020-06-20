package tictactoe;

import java.util.Random;

public class MediumBot extends Player {
    Random random = new Random();
    char[][] game;

    public MediumBot(char symbol) {
        super("medium", symbol);
        System.out.println("Medium bot created");
    }

    @Override
    public void makeMove(char[][] game) {
        this.game = game;

        if (checkRow()) return;
        if (checkColumn()) return;
        if (checkDiagonal()) return;

        utils.makeRandomMove(game, random, symbol);
        printMove();
    }

    private boolean checkRow() {
        for (int i = 0; i < 3; i++) {
            if (checkThreeCellsAndAddByYX(new int[]{i, 0, i, 1, i, 2})) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumn() {
        for (int i = 0; i < 3; i++) {
            if (checkThreeCellsAndAddByYX(new int[]{0, i, 1, i, 2, i})) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonal() {
        if (game[1][1] == '_') {
            if (checkThreeCellsAndAddByYX(new int[]{0, 0, 2, 2, 1, 1})) {
                return true;
            }
            return checkThreeCellsAndAddByYX(new int[]{0, 2, 2, 0, 1, 1});
        } else {
            if (checkThreeCellsAndAddByYX(new int[]{1, 1, 0, 0, 2, 2})) {
                return true;
            }
            if (checkThreeCellsAndAddByYX(new int[]{1, 1, 2, 2, 0, 0})) {
                return true;
            }
            if (checkThreeCellsAndAddByYX(new int[]{1, 1, 0, 2, 2, 0})) {
                return true;
            }
            return checkThreeCellsAndAddByYX(new int[]{1, 1, 2, 0, 0, 2});
        }
    }
    private boolean checkThreeCellsAndAddByYX(int[] yX) {
        int nextMove = checkThreeCells(new char[] {game[yX[0]][yX[1]], game[yX[2]][yX[3]], game[yX[4]][yX[5]]});
        if (nextMove != -1) {
            game[yX[nextMove * 2]][yX[nextMove * 2 + 1]] = symbol;
            printMove();
            return true;
        }
        return false;
    }

    private int checkThreeCells(char[] cells) {
        if (cells[0] == '_' && cells[1] == cells[2] && cells[1] != '_' ) {
            return 0;
        }
        if (cells[1] == '_' && cells[0] == cells[2] && cells[0] != '_' ) {
            return 1;
        }
        if (cells[2] == '_' && cells[0] == cells[1] && cells[0] != '_' ) {
            return 2;
        }
        return -1;
    }
}