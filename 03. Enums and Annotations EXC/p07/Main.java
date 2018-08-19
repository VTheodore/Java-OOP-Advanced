package EnumsAndAnnotationsEXC.p07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));

        String line;

        if ("EnumsAndAnnotationsEXC.p08.Card EnumsAndAnnotationsEXC.p08.Deck".equals(line = in.readLine())){
            List<String> deck = Deck.getCards();

            for (String card : deck) {
                System.out.println(card);
            }
        }
    }
}
