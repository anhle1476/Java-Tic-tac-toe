package tictactoe;

import java.util.Random;

public class GameUtils {
    public void makeRandomMove(char[][] game, Random random, char symbol) {
        int dX, dY;
        do {
            dX = random.nextInt(3);
            dY = random.nextInt(3);
        } while (game[dX][dY] != '_');
        game[dX][dY] = symbol;
    }

    public String checkState(char[][] game) {
        String state = isWin(game);
        if (state != null) return state;
        return isDraw(game);
    }

    private String isDraw(char[][] game) {
        for (char[] row : game) {
            for (char cell : row) {
                if (cell == '_') return null;
            }
        }
        return "Draw";
    }

    private String isWin(char[][] game) {
        // check row
        for (char[] row : game) {
            if (row[0] != '_' && row[0] == row[1] && row[0] == row[2]) {
                return winStatus(row[0]);
            }
        }
        // check column
        for (int i = 0; i < 3; i++) {
            if (game[0][i] != '_' && game[0][i] == game[1][i] && game[0][i] == game[2][i]) {
                return winStatus(game[0][i]);
            }
        }
        // check diagonal
        if (game[0][0] != '_' && game[0][0] == game[1][1] && game[0][0] == game[2][2]) {
            return winStatus(game[0][0]);
        }
        if (game[0][2] != '_' && game[0][2] == game[1][1] && game[0][2] == game[2][0]) {
            return winStatus(game[0][2]);
        }
        return null;
    }

    private String winStatus(char winner) {
        return winner + " wins";
    }
}