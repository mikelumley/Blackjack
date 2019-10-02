public class Card {

    public enum Suit {SPADE, CLUB, DIAMOND, HEART};
    public static final String[] VALUES = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "JACK", "QUEEN", "KING", "ACE"};

    public Suit suit;
    public String name;
    public int value;

    public Card(String name, Suit suit){
        this.name = name;
        this.suit = suit;

        if(name.equals("JACK") || name.equals("QUEEN") || name.equals("KING")) {
            this.value = 10;
        }
        else if(name.equals("ACE")) {
            this.value = 11;
        }
        else {
            try {
                this.value = Integer.parseInt(name);
            } catch(Exception e) {
                System.err.println("Invalid card name");
            }
        }
    }

    public String toString() {
        return "[" + name + ", " + suit + "]";
    }


}
