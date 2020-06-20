package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PlayerFactory playerFactory = new PlayerFactory();
        Game game;
        boolean isPlaying = true;

        Player player1, player2;

        while (isPlaying) {
            System.out.println("\nInput command: ");
            System.out.println("Ex: start user medium, start easy hard, exit, ...\n");
            String[] commands = scanner.nextLine().split("\\s+");
            switch (commands[0]) {
                case "exit":
                    isPlaying = false;
                    break;
                case "start":
                    if (commands.length != 3) {
                        System.out.println("Bad parameters!");
                        break;
                    }
                    player1 = playerFactory.getPlayer(commands[1], 'X');
                    player2 = playerFactory.getPlayer(commands[2], 'O');

                    if (player1 != null && player2 != null) {
                        game = new Game(player1, player2);
                        game.playing(scanner);
                    }
                    break;
                default:
                    System.out.println("Bad parameters!");
            }
        }
    }
}