import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CardTest {

    @Test
    void givenCardKingDiamond_checkToString_returnKingDiamondAndValue10() {
        Card card = new Card("KING", Card.Suit.DIAMOND);
        assertEquals(card.toString(), "[KING, DIAMOND]");
        assertEquals(card.value, 10);
    }
}
