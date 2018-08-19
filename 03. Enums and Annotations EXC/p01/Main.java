package EnumsAndAnnotationsEXC.p01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));

        String input = in.readLine();
        if ("EnumsAndAnnotationsEXC.p08.Card Suits".equals(input)) {
            CardSuit[] cardSuit = CardSuit.values();
            System.out.println("EnumsAndAnnotationsEXC.p08.Card Suits:");

            for (CardSuit card : cardSuit) {
                System.out.printf("Ordinal value: %d; Name value: %s%n", card.ordinal(), card.name());
            }
        }
    }
}
