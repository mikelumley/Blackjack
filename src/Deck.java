import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Deck {

    private ArrayList<Card> cards = new ArrayList<Card>();

    public Deck() {
        for(Card.Suit suit : Card.Suit.values()) {
            for(String name : Arrays.asList(Card.VALUES)) {
                cards.add(new Card(name, suit));
            }
        }
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public Card drawCard() {
        Random r = new Random();
        int index = r.nextInt(cards.size());
        return cards.remove(index);
    }
}
