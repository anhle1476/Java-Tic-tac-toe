package tictactoe;

public class PlayerFactory {
    Player player;

    public Player getPlayer(String type, char symbol) {
        switch (type.toLowerCase()) {
            case "user":
                this.player = new User(symbol);
                break;
            case "easy":
                this.player = new EasyBot(symbol);
                break;
            case "medium":
                this.player = new MediumBot(symbol);
                break;
            case "hard":
                this.player = new HardBot(symbol);
                break;
            default:
                System.out.println("Player invalid!");
                this.player = null;
        }
        return this.player;
    }
}