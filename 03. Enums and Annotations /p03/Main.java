package EnumsAndAnnotations.p03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));

        CoffeeMachine cm = new CoffeeMachine();

        String line;
        while (!"END".equals((line = in.readLine()))){
            String[] cmdArgs = line.split("\\s+");

            switch (cmdArgs.length){
                case 1:
                    cm.insertCoin(cmdArgs[0]);
                    break;
                case 2:
                    cm.buyCoffee(cmdArgs[0], cmdArgs[1]);
                    break;
            }
        }

        Iterable<Coffee> coffeeSold = cm.coffeesSold();

        for (Coffee coffee : coffeeSold) {
            System.out.println(coffee.toString());
        }
    }
}
