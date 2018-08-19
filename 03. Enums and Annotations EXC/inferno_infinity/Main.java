package EnumsAndAnnotationsEXC.inferno_infinity;

import EnumsAndAnnotationsEXC.inferno_infinity.weapons.Axe;
import EnumsAndAnnotationsEXC.inferno_infinity.weapons.Knife;
import EnumsAndAnnotationsEXC.inferno_infinity.weapons.Sword;
import EnumsAndAnnotationsEXC.inferno_infinity.weapons.Weapon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Weapon> weapons = new HashMap<>();

        String line;
        while (!"END".equals(line = in.readLine())){
            String[] cmdArgs = line.split(";");

            switch (cmdArgs[0]){
                case "Create":
                    switch (cmdArgs[1].toLowerCase()){
                        case "axe":
                            Weapon axe = new Axe(cmdArgs[2]);
                            weapons.putIfAbsent(cmdArgs[2], axe);
                            break;
                        case "sword":
                            Weapon sword = new Sword(cmdArgs[2]);
                            weapons.putIfAbsent(cmdArgs[2], sword);
                            break;
                        case "knife":
                            Weapon knife = new Knife(cmdArgs[2]);
                            weapons.putIfAbsent(cmdArgs[2], knife);
                            break;
                    }
                    break;
                case "Add":
                    if (weapons.containsKey(cmdArgs[1])){
                        Weapon weapon = weapons.get(cmdArgs[1]);
                        weapon.addGem(Integer.parseInt(cmdArgs[2]), cmdArgs[3]);
                    }
                    break;
                case "Remove":
                    if (weapons.containsKey(cmdArgs[1])){
                        Weapon weapon = weapons.get(cmdArgs[1]);
                        weapon.removeGem(Integer.parseInt(cmdArgs[2]));
                    }
                    break;
                case "Compare":
                    if (weapons.containsKey(cmdArgs[1]) && weapons.containsKey(cmdArgs[2])){
                        Weapon firstWeapon = weapons.get(cmdArgs[1]);
                        firstWeapon.updateStats();
                        Weapon secondWeapon = weapons.get(cmdArgs[2]);
                        secondWeapon.updateStats();

                        if (firstWeapon.compareTo(secondWeapon) >= 0){
                            System.out.println(firstWeapon.toString());
                        }else if (firstWeapon.compareTo(secondWeapon) < 0){
                            System.out.println(secondWeapon.toString());
                        }
                    }
                    break;
                case "Print":
                    if (weapons.containsKey(cmdArgs[1])){
                        Weapon weapon = weapons.get(cmdArgs[1]);
                        weapon.updateStats();
                        System.out.println(weapon.toString());
                    }
                    break;
            }
        }
    }
}
