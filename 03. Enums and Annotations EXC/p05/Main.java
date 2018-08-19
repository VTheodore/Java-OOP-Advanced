package EnumsAndAnnotationsEXC.p05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));

        String firstCardCardRank = in.readLine();
        String firstCardCardSuit = in.readLine();

        Card firstCard = new Card(firstCardCardRank, firstCardCardSuit);

        String secondCardCardRank = in.readLine();
        String secondCardCardSuit = in.readLine();

        Card secondCard = new Card(secondCardCardRank, secondCardCardSuit);

        if (firstCard.compareTo(secondCard) > 0){
            System.out.println(firstCard.toString());
        }else {
            System.out.println(secondCard.toString());
        }
    }
}
