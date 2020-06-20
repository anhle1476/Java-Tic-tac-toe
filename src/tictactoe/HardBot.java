package tictactoe;

import java.util.HashMap;

public class HardBot extends Player {
    private final HashMap<String, Integer> stateMap = new HashMap<>();
    private final char opponent;
    char[][] game;

    public HardBot(char symbol) {
        super("hard", symbol);
        opponent = symbol == 'X' ? 'O' : 'X';

        stateMap.put("Draw", 0);
        stateMap.put("X wins", symbol == 'X' ? 1 : -1);
        stateMap.put("O wins", symbol == 'O' ? 1 : -1);
    }

    @Override
    public void makeMove(char[][] game) {
        // update local game board
        this.game = game;

        int bestX = -1, bestY = -1;
        int bestScore = Integer.MIN_VALUE;

        // loop through empty cells and use minimax to get best move
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (game[i][j] == '_') {
                    game[i][j] = symbol;
                    int thisScore = miniMax(5, false);
                    if (thisScore > bestScore) {
                        bestScore = thisScore;
                        bestY = i;
                        bestX = j;
                    }
                    game[i][j] = '_';
                }
            }
        }
        if (bestX != -1 && bestY != -1) {
            game[bestY][bestX] = symbol;
            printMove();
        } else {
            System.out.println("Error: Hard-Bot error.");
        }
    }

    private int miniMax( int dept, boolean isMaximize) {
        // check current state, get corresponding value from hashmap
        String thisState = utils.checkState(game);
        if (thisState != null) {
            return stateMap.get(thisState);
        }
        // prevent searching too deep
        if (dept == 0) {
            return 0;
        }
        // using recursion -> alternating btw max & min player until game over or reach dept
        int score = isMaximize ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        char thisSymbol = isMaximize ? symbol : opponent;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (game[i][j] == '_') {
                    game[i][j] = thisSymbol;
                    int thisMoveScore = miniMax(dept - 1, !isMaximize);
                    score = isMaximize ? Math.max(score, thisMoveScore) : Math.min(score, thisMoveScore);
                    game[i][j] = '_';
                }
            }
        }
        return score;
    }
}