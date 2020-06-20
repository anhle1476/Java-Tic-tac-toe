package tictactoe;

import java.util.Scanner;

public class User extends Player {
    Scanner scanner = new Scanner(System.in);

    public User(char symbol) {
        super(symbol);
    }

    @Override
    public void makeMove(char[][] game) {
        boolean isMakingMove = true;
        while (isMakingMove) {
            System.out.print("Enter the coordinates: ");
            String[] input = scanner.nextLine().trim().split(" ");
            try {
                int dX = Integer.parseInt(input[0]);
                int dY = Integer.parseInt(input[1]);
                if (dX > 3 || dX < 1 || dY > 3 || dY < 1) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }
                int realX = dX - 1;
                int realY = 3 - dY;
                if (game[realY][realX] == '_') {
                    game[realY][realX] = symbol;
                    isMakingMove = false;
                } else {
                    System.out.println("This cell is occupied! Choose another one!");
                }
            } catch (NumberFormatException exception) {
                System.out.println("You should enter numbers!");
            } catch (NullPointerException exception) {
                System.out.println("You should enter two numbers!");
            }
        }
    }
}
