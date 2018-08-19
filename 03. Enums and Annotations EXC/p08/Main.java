package EnumsAndAnnotationsEXC.p08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));

        String playerOneName = in.readLine();
        String playerTwoName = in.readLine();

        Player playerOne = new Player(playerOneName);
        Player playerTwo = new Player(playerTwoName);

        Deck deck = new Deck();

        addCards(in, playerOne, deck);
        addCards(in, playerTwo, deck);


        if (playerOne.compareTo(playerTwo) > 0){
            System.out.println(playerOne);
        }else {
            System.out.println(playerTwo);
        }
    }

    private static void addCards(BufferedReader in, Player playerOne, Deck deck) throws IOException {
        while (playerOne.needsMoreCards()){
            String[] cmdArgs = in.readLine().split("\\s+");

            String cardRank = cmdArgs[0].toUpperCase();
            String cardSuit = cmdArgs[2].toUpperCase();

            try{
                playerOne.addCard(cardRank, cardSuit, deck);
            }catch (IllegalArgumentException iae){
                System.out.println(iae.getMessage());
            }
        }
    }
}
