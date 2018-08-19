package EnumsAndAnnotationsEXC.p07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private Deck() {
    }

    public static List<String> getCards(){
        List<String> deck = new ArrayList<>();

        CardRank[] cardRanks = CardRank.values();
        CardSuit[] cardSuits = CardSuit.values();



        for (CardSuit suit : cardSuits) {
            for (CardRank rank : cardRanks) {
                String card = String.format("%s of %s", rank.name(), suit.name());
                deck.add(card);
            }
        }

        return Collections.unmodifiableList(deck);
    }
}
