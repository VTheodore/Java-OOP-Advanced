package EnumsAndAnnotationsEXC.p06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));

        String line = in.readLine();

        String result = null;

        if ("Rank".equals(line)) {
            CustomEnumAnnotation rankAnnotation = CardRank.class.getAnnotation(CustomEnumAnnotation.class);
            result = String.format("Type = %s, Description = %s", rankAnnotation.type(), rankAnnotation.description());
        } else if ("Suit".equals(line)) {
            CustomEnumAnnotation suitAnnotation = CardSuit.class.getAnnotation(CustomEnumAnnotation.class);
            result = String.format("Type = %s, Description = %s", suitAnnotation.type(), suitAnnotation.description());
        }

        System.out.println(result);
    }
}
