package GenericsEXC.Tupples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));

        String[] nameArgs = in.readLine().split("\\s+");
        String name = nameArgs[0] + " " + nameArgs[1];
        Threeuple<String, String, String> nameAddressAndTown = new Threeuple<>(name, nameArgs[2], nameArgs[3]);
        System.out.println(nameAddressAndTown.toString());

        String[] beerArgs  = in.readLine().split("\\s+");

        Threeuple<String, Integer, Boolean> drinkingInfo = null;

        if ("drunk".equals(beerArgs[2])){
            drinkingInfo = new Threeuple<>(beerArgs[0], Integer.parseInt(beerArgs[1]), true);
        }else{
            drinkingInfo = new Threeuple<>(beerArgs[0], Integer.parseInt(beerArgs[1]), false);
        }

        System.out.println(drinkingInfo.toString());

        String[] bankArgs = in.readLine().split("\\s+");
        Threeuple<String, Double, String> bankInfo = new Threeuple<>(bankArgs[0], Double.parseDouble(bankArgs[1]), bankArgs[2]);
        System.out.println(bankInfo.toString());
    }
}
