package EnumsAndAnnotationsEXC.p08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player implements Comparable<Player>{
    private String name;

    private List<Card> cards;

    private Card winningCard;

    public Player(String name) {
        this.setName(name);
        this.cards = new ArrayList<>();
    }

    private void setName(String name) {
        this.name = name;
    }

    public void addCard(String cardRank, String cardSuit, Deck deck) {
        Card card;
        try {
            card = new Card(cardRank, cardSuit);
        } catch (IllegalArgumentException iae) {
            throw new IllegalArgumentException("No such card exists.");
        }

        if (!deck.isInDeck(card)) {
            throw new IllegalArgumentException("EnumsAndAnnotationsEXC.p08.Card is not in the deck.");
        }

        deck.removeCardFromGame(card);
        this.cards.add(card);
    }

    public boolean needsMoreCards(){
        return this.cards.size() < 5;
    }

    public List<Card> getCards(){
        return Collections.unmodifiableList(this.cards);
    }

    public void setWinningCard(Card card){
        this.winningCard = card;
    }

    public Card getWinningCard() {
        return this.winningCard;
    }

    @Override
    public String toString() {
        return String.format("%s wins with %s.", this.name, this.getWinningCard().toString());
    }

    @Override
    public int compareTo(Player o) {
        Card playerOnesHighestPoweredCard = this.cards.get(0);

        for (Card card : this.cards) {
            if (card.compareTo(playerOnesHighestPoweredCard) >= 0){
                playerOnesHighestPoweredCard = card;
            }
        }

        Card playerTwosHighestPoweredCard = o.getCards().get(0);

        for (Card card : o.getCards()) {
            if (card.compareTo(playerTwosHighestPoweredCard) >= 0){
                playerTwosHighestPoweredCard = card;
            }
        }

        if (playerOnesHighestPoweredCard.compareTo(playerTwosHighestPoweredCard) > 0){
            this.setWinningCard(playerOnesHighestPoweredCard);
            return 1;
        } else if (playerOnesHighestPoweredCard.compareTo(playerTwosHighestPoweredCard) < 0){
            o.setWinningCard(playerTwosHighestPoweredCard);
            return -1;
        }

        return 0;
    }
}
