import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class DeckTest {

    @Test
    void givenDeck_checkIfDeck_return52Cards() {
        Deck deck =  new Deck();
        assertEquals(deck.getCards().size(), 52);
    }

    @Test
    void givenFullDeck_checkIfDeck_return13HeartsCards() {
        Deck deck =  new Deck();
        ArrayList<Card> hearts = new ArrayList<Card>();

        for(Card card : deck.getCards()) {
            if(card.suit == Card.Suit.HEART) {
                hearts.add(card);
            }
        }

        assertEquals(hearts.size(), 13);
    }
}
