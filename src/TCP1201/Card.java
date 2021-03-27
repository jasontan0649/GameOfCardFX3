package TCP1201;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

public class Card implements Comparable<Card> {
    private char suit;
    private char value;
    private static ArrayList<Integer> rD = rDData();

    private final static String VALID_SUIT = "cdhs";
    private final static String VALID_VALUE = "A23456789XJQK";
    private final static ArrayList<Card> CARDS = geneCards();

    public Card(String cardValue) {
        setCard(cardValue);
    }

    //getterz
    public char getSuit() {
        return this.suit;
    }

    public char getValue() {
        return this.value;
    }

    public int getWeight() {
        return VALID_VALUE.indexOf(this.value);
    }

    public int getPoint() {
        return Math.min(this.getWeight() + 1, 10);
    }

    public int getSuitWeight() {
        return VALID_SUIT.indexOf(this.suit);
    }

    public String getCard() {
        return "" + this.suit + this.value;
    }

    public void setCard(String cardValue) {
        setSuit(cardValue.charAt(0));
        setValue(cardValue.charAt(1));
    }

    private void setSuit(char suit) {
        suit = Character.toLowerCase(suit);
        this.suit = suit;
    }

    private void setValue(char value) {
        value = Character.toUpperCase(value);
        this.value = value;
    }

    //static method for initialize stack of card to program
    private static ArrayList<Card> geneCards() {
        ArrayList<Card> cards = new ArrayList<Card>(52);
        char[] suits = VALID_SUIT.toCharArray();
        char[] values = VALID_VALUE.toCharArray();

        for (char value : values)
            for (char suit : suits)
                cards.add(new Card("" + suit + value));

        return cards;
    }

    private static ArrayList<Integer> rDData() {
        ArrayList<Integer> numbers = new ArrayList<>(52);
        for (int i = 0; i < 52; i++)
            numbers.add(i);
        return numbers;
    }

    //static method for instantiate a stack of shuffled cards
    public static Stack<Card> newShuffleCards() {
        Collections.shuffle(rD);

        Stack<Card> newCards = new Stack<>();
        for (Integer i : rD)
            newCards.push(CARDS.get(i));

        Collections.shuffle(newCards);
        return newCards;
    }


    //comparable
    public int compareTo(Card c) {
        return this.getWeight() - c.getWeight();
    }

    //toString
    @Override
    public String toString() {
        return this.getCard();
    }

}

class suitComparator implements Comparator<Card> {
    @Override
    public int compare(Card c1, Card c2) {
        if (c1.getSuitWeight() != c2.getSuitWeight())
            return c1.getSuitWeight() - c2.getSuitWeight();
        else
            return c1.compareTo(c2);
    }
}

