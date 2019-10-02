public class Game {

    private static final int CARDS_TO_DEAL_AT_START = 2;

    private Player player = new Player("Player");
    private Player dealer = new Player("Dealer");
    private Deck deck = new Deck();

    public Player getPlayer() {
        return player;
    }
    public Player getDealer() {
        return dealer;
    }
    public Deck getDeck() {
        return deck;
    }

    public void startGame() {
        for(int i=0; i<CARDS_TO_DEAL_AT_START; i++) {
            player.addCard(deck.drawCard());
            dealer.addCard(deck.drawCard());
        }
    }

    public Card hit(Player player) {
        Card card = deck.drawCard();
        player.addCard(card);
        return card;
    }

    public void stand(Player player) {
        player.setPlayerStanding(true);
    }

    public Player hasWon() {
        if(!player.isBust() && dealer.isBust()) {
            return player;
        }
        else if(player.isBust() && !dealer.isBust()) {
            return dealer;
        }
        else if(player.getScore() > dealer.getScore()) {
            return player;
        }
        else if(player.getScore() < dealer.getScore()) {
            return dealer;
        }
        else {
            return null;
        }
    }
}
