import java.util.ArrayList;

public class Player {

    private static final int MAX_SCORE = 21;

    private ArrayList<Card> hand = new ArrayList<Card>();
    private boolean isStanding = false;
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public int getScore() {
        int score = 0;
        int numAces = 0;

        for(Card card : hand) {
            if(card.name.equals("ACE")) {
                numAces += 1;
            }
            score += card.value;
        }

        while(score > MAX_SCORE && numAces > 0) {
            score -= 10;
            numAces -= 1;
        }

        return score;
    }

    public boolean isPlayerStanding() {
        return isStanding;
    }

    public void setPlayerStanding(boolean isStanding) {
        this.isStanding = isStanding;
    }

    public boolean isBust() {
        return getScore() > MAX_SCORE;
    }

    public void addCard(Card card) {
        this.hand.add(card);
    }

    public String printHand() {
        return hand.toString();
    }
}
