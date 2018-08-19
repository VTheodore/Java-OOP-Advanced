package EnumsAndAnnotationsEXC.p03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));

        String cardRank = in.readLine();
        String cardSuit = in.readLine();

        Card card = new Card(cardRank, cardSuit);

        System.out.println(card.toString());
    }
}
