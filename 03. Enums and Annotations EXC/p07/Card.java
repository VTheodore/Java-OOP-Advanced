package EnumsAndAnnotationsEXC.p07;

public class Card implements Comparable<Card>{
    private CardRank cardRank;

    private CardSuit cardSuit;

    public Card(String cardRank, String cardSuit) {
        this.setCardRank(cardRank);
        this.setCardSuit(cardSuit);
    }

    private String getCardRank() {
        return this.cardRank.name();
    }

    private void setCardRank(String cardRank) {
        this.cardRank = CardRank.valueOf(cardRank.toUpperCase());
    }

    private String getCardSuit() {
        return this.cardSuit.name();
    }

    private void setCardSuit(String cardSuit) {
        this.cardSuit = CardSuit.valueOf(cardSuit.toUpperCase());
    }

    private int getCardPower(){
        return this.cardRank.getValue() + this.cardSuit.getValue();
    }


    @Override
    public String toString() {
        return String.format("EnumsAndAnnotationsEXC.p08.Card name: %s of %s; EnumsAndAnnotationsEXC.p08.Card power: %d", this.getCardRank(), this.getCardSuit(), this.getCardPower());
    }


    @Override
    public int compareTo(Card o) {
        if (Integer.compare(this.getCardPower(), o.getCardPower()) > 0){
            return 1;
        }else if (Integer.compare(this.getCardPower(), o.getCardPower()) < 0){
            return -1;
        }

        return 0;
    }
}
