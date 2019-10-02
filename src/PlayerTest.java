import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    private Card SK = new Card("KING", Card.Suit.SPADE);
    private Card DA = new Card("ACE", Card.Suit.DIAMOND);
    private Card D2 = new Card("2", Card.Suit.DIAMOND);

    @Test
    void givenPlayerIsBust_checkIsBust_returnTrue() {
        Player player = new Player("Player");

        player.addCard(SK);
        player.addCard(SK);
        player.addCard(SK);

        assertTrue(player.isBust());
    }

    @Test
    void givenPlayerIsNotBust_checkIsBust_returnFalse() {
        Player player = new Player("Player");

        player.addCard(SK);
        player.addCard(DA);

        assertFalse(player.isBust());
    }

    @Test
    void given2King2_checkGetScore_return14() {
        Player player = new Player("Player");

        player.addCard(D2);
        player.addCard(SK);
        player.addCard(D2);

        assertEquals(player.getScore(), 14);
    }

    @Test
    void givenAceKing2_checkGetScore_return13() {
        Player player = new Player("Player");

        player.addCard(SK);
        player.addCard(DA);
        player.addCard(D2);

        assertEquals(player.getScore(), 13);
    }

    @Test
    void givenAceAce2_checkGetScore_return14() {
        Player player = new Player("Player");

        player.addCard(DA);
        player.addCard(DA);
        player.addCard(D2);

        assertEquals(player.getScore(), 14);
    }
}