package tictactoe;

abstract class Player {
    String level;
    char symbol;
    GameUtils utils;

    public Player(char symbol) {
        this.symbol = symbol;
    };

    public Player (String level, char symbol) {
        this.level = level;
        this.symbol = symbol;
        this.utils = new GameUtils();
    }

    abstract public void makeMove(char[][] game);

    public void printMove() {
        System.out.println("Making move level \"" + level + "\"");
    }
}