package GenericsEXC.CustomList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));

        String line;

        CustomList<String> list = new CustomList<>();
        while (!(line = in.readLine()).equals("END")){
            String[] cmdArgs = line.split("\\s+");

            String command = cmdArgs[0];

            switch (command){
                case "Add":
                    list.add(cmdArgs[1]);
                    break;
                case "Remove":
                    list.remove(Integer.parseInt(cmdArgs[1]));
                    break;
                case "Contains":
                    System.out.println(list.contains(cmdArgs[1]));
                    break;
                case "Swap":
                    list.swap(Integer.parseInt(cmdArgs[1]), Integer.parseInt(cmdArgs[2]));
                    break;
                case "Greater":
                    System.out.println(list.countGreaterThan(cmdArgs[1]));
                    break;
                case "Max":
                    System.out.println(list.getMax());
                    break;
                case "Min":
                    System.out.println(list.getMin());
                    break;
                case "Sort":
                    Sorter.sort(list);
                    break;
                case "Print":
                    for (String s : list) {
                        System.out.println(s);
                    }
                    break;
            }
        }
    }
}
