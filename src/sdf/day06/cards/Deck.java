package sdf.day06.cards;

import java.util.LinkedList;
import java.util.List;

public class Deck {
    private List<Card> deck;

    public Deck() {
        deck = new LinkedList<>();
        for (String suit : Constants.SUITS) {
            for (int i = 0; i < Constants.NAMES.length; i++){
                Card card = new Card(suit, Constants.NAMES[i], Constants.VALUES[i]);
                deck.add(card);
            }
        }    
    }

    public void shuffle() {

    }

    public Card take() {
        List<Card> cards = take(1);
        return cards.get(0);
    }

    public List<Card> take(int count) {
        List<Card> toReturn = new LinkedList<>();

        int i = 0;
        while (!deck.isEmpty() && i < count) {
            toReturn.add(deck.remove(i));
            i++;
        }
        
        return toReturn;
    }

}
