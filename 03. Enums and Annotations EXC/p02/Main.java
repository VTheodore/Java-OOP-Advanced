package EnumsAndAnnotationsEXC.p02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));

        String line = in.readLine();

        if ("EnumsAndAnnotationsEXC.p08.Card Ranks".equals(line)){
            CardRank[] cardRanks = CardRank.values();

            System.out.println("EnumsAndAnnotationsEXC.p08.Card Ranks:");

            for (CardRank card : cardRanks) {
                System.out.printf("Ordinal value: %s; Name value: %s%n", card.ordinal(), card.name());
            }
        }
    }
}
