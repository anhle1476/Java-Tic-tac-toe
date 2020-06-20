package tictactoe;

import java.util.Random;

public class EasyBot extends Player {
    Random random = new Random();

    public EasyBot(char symbol) {
        super("easy", symbol);
    }

    @Override
    public void makeMove(char[][] game) {
        utils.makeRandomMove(game, random, symbol);
        printMove();
    }
}