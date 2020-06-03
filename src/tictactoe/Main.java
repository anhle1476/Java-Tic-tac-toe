package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isPlaying = true;
        int turnsCount = 0;
        char[][] game = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
        printGame(game);

        while (isPlaying) {
            int[] coordinate = getCoordinate(scanner, game);
            game[coordinate[0]][coordinate[1]] = turnsCount++ % 2 == 0 ? 'X' : 'O';
            printGame(game);
            isPlaying = checkState(game);
        }
    }

    private static void printGame(char[][] game) {
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


    private static int[] getCoordinate(Scanner scanner, char[][] game) {
        int[] newCoordinate = null;
        while (newCoordinate == null) {
            System.out.print("Enter the coordinates: ");
            String[] input = scanner.nextLine().trim().split(" ");
            try {
                int dX = Integer.parseInt(input[0]);
                int dY = Integer.parseInt(input[1]);
                if (dX > 3 || dX < 1 || dY > 3 || dY < 1 ) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }
                int realX = dX - 1;
                int realY = 3 - dY;
                if (game[realY][realX] == ' ') {
                    newCoordinate = new int[]{realY, realX};
                } else {
                    System.out.println("This cell is occupied! Choose another one!");
                }
            } catch (NumberFormatException exception) {
                System.out.println("You should enter numbers!");
            } catch (NullPointerException exception) {
                System.out.println("You should enter two numbers!");
            }
        }
        return newCoordinate;
    }

    private static boolean checkState(char[][] game) {
        if (!isWin(game)) {
            if (isDraw(game)) {
                System.out.println("Draw");
            } else  {
                return true;
            }
        }
        return false;
    }

    private static boolean isDraw(char[][] game) {
        for (char[] row : game) {
            for (char cell : row) {
                if (cell == ' ') return false;
            }
        }
        return true;
    }

    private static boolean isWin(char[][] game) {
        // check row
        for (char[] row : game) {
            if (row[0] != ' ' && row[0] == row[1] && row[0] == row[2]) {
                return winnerAnnounce(row[0]);
            }
        }
        // check column
        for (int i = 0; i < 3; i++) {
            if (game[0][i] != ' ' && game[0][i] == game[1][i] && game[0][i] == game[2][i]) {
                return winnerAnnounce(game[0][i]);
            }
        }
        // check diagonal
        if (game[0][0] != ' ' && game[0][0] == game[1][1] && game[0][0] == game[2][2]) {
            return winnerAnnounce(game[0][0]);
        }
        if (game[0][2] != ' ' && game[0][2] == game[1][1] && game[0][2] == game[2][0]) {
            return winnerAnnounce(game[0][2]);
        }
        return false;
    }

    private static boolean winnerAnnounce(char winner) {
        System.out.println(winner + " wins");
        return true;
    }
}
