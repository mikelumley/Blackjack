import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private Card H4 = new Card("4", Card.Suit.HEART);
    private Card D6 = new Card("6", Card.Suit.DIAMOND);
    private Card H2 = new Card("2", Card.Suit.HEART);
    private Card D3 = new Card("3", Card.Suit.DIAMOND);
    private Card HK = new Card("KING", Card.Suit.HEART);

    private Game setup(Card p1, Card p2, Card p3, Card d1, Card d2, Card d3) {
        Game game = new Game();

        game.getPlayer().addCard(p1);
        game.getPlayer().addCard(p2);
        game.getPlayer().addCard(p3);

        game.getDealer().addCard(d1);
        game.getDealer().addCard(d2);
        game.getDealer().addCard(d3);

        return game;
    }

    @Test
    void givenPlayerScoreHigherThanDealer_checkIfHasWon_returnPlayer() {
        Game game = setup(H4, D6, H2, H2, D3, H2);
        Player player = game.hasWon();
        assertEquals(player, game.getPlayer());
    }

    @Test
    void givenDealerScoreHigherThanPlayer_checkIfHasWon_returnDealer() {
        Game game = setup(H2, D3, H2, H4, D6, H2);
        Player player = game.hasWon();
        assertEquals(player, game.getDealer());
    }

    @Test
    void givenDealerBustPlayerNot_checkHasWon_returnPlayer() {
        Game game = setup(H4, HK, D6, HK, HK, HK);
        Player player = game.hasWon();
        assertEquals(player, game.getPlayer());
    }

    @Test
    void givenPlayerBustDealerNot_checkHasWon_returnDealer() {
        Game game = setup(HK, HK, HK, H4, HK, D6);
        Player player = game.hasWon();
        assertEquals(player, game.getDealer());
    }

    @Test
    void givenPlayerAndDealerScoreSame_checkHasWon_returnNull() {
        Game game = setup(D6, D6, D6, D6, D6, D6);
        Player player = game.hasWon();
        assertEquals(player, null);
    }

    @Test
    void givenStartOfGame_checkIfStartGame_givesPlayer2Cards() {
        Game game = new Game();
        game.startGame();
        assertEquals(game.getPlayer().getHand().size(), 2);
    }

    @Test
    void givenStartOfGame_checkIfStartGame_givesDealer2Cards() {
        Game game = new Game();
        game.startGame();
        assertEquals(game.getDealer().getHand().size(), 2);
    }

    @Test
    void givenStartOfGame_checkIfStartGame_decreasesDeckSizeBy4() {
        Game game = new Game();
        game.startGame();
        assertEquals(game.getDeck().getCards().size(), 52 - 4);
    }

    @Test
    void givenStartingHand_checkIfHit_addsNewCardScoreToScore() {
        Game game = new Game();
        int curScore = game.getPlayer().getScore();
        int newScore = game.hit(game.getPlayer()).value + curScore;
        assertEquals(game.getPlayer().getScore(), newScore);
    }

    @Test
    void givenStartingHand_checkIfStand_doesNotChangeScore() {
        Game game = new Game();
        int curScore = game.getPlayer().getScore();
        game.stand(game.getPlayer());
        assertEquals(game.getPlayer().getScore(), curScore);
    }
}