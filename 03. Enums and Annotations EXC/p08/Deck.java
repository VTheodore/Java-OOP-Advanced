package EnumsAndAnnotationsEXC.p08;

import java.util.*;

public class Deck {
    private Map<String, Card> cards;

    public Deck() {
        this.setCards();

    }

    private void setCards(){
        this.cards = new HashMap<>();

        CardRank[] cardRanks = CardRank.values();
        CardSuit[] cardSuits = CardSuit.values();



        for (CardSuit suit : cardSuits) {
            for (CardRank rank : cardRanks) {
                Card card = new Card(rank.name(), suit.name());
                this.cards.put(card.toString(), card);
            }
        }
    }

    public void removeCardFromGame(Card card){
        this.cards.remove(card.toString());
    }

    public boolean isInDeck(Card card){
        return this.cards.containsKey(card.toString());

    }
}
