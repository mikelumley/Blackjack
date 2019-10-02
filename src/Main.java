import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to Blackjack");

        game.startGame();

        // Player Logic
        while(game.getPlayer().isBust() == false && game.getPlayer().isPlayerStanding() == false) {
            System.out.println("\nYour score is: " + game.getPlayer().getScore());
            System.out.println("with hand: " + game.getPlayer().printHand());
            System.out.println("Hit or stay? (Hit = 1, Stay = 0)");

            try {
                int command = in.nextInt();

                if (command == 0) {
                    game.stand(game.getPlayer());
                    System.out.println("\nDealer score is: " + game.getDealer().getScore());
                    System.out.println("with hand: " + game.getDealer().printHand());
                }
                else if (command == 1) {
                    Card card = game.hit(game.getPlayer());
                    System.out.println("You draw: " + card.toString());
                }
                else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Error: Invalid Command");
            }
        }

        // Dealer Logic
        while(game.getDealer().getScore() < 17 && game.getDealer().getScore() <= game.getPlayer().getScore() && !game.getPlayer().isBust()) {
            Card card = game.hit(game.getDealer());
            System.out.println("\nDealer draws: " + card.toString());
            System.out.println("\nDealer score is: " + game.getDealer().getScore());
            System.out.println("with hand: " + game.getDealer().printHand());
        }

        if(game.hasWon() == null) {
            System.out.println("\nTie!");
        }
        else {
            System.out.println("\n" + game.hasWon().getName() + " wins!");
        }

    }
}
