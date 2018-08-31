package onehitdungeon;

import onehitdungeon.interfaces.DungeonManager;
import onehitdungeon.interfaces.InputReader;
import onehitdungeon.interfaces.OutputWriter;
import onehitdungeon.io.ConsoleReader;
import onehitdungeon.io.ConsoleWriter;
import onehitdungeon.manager.DungeonManagerImpl;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static String COMMAND_SPLITTER = "\\s+";

    private static String HERO_COMMAND = "Hero";

    private static String SELECT_COMMAND = "Select";

    private static String STATUS_COMMAND = "Status";

    private static String FIGHT_COMMAND = "Fight";

    private static String ADVANCE_COMMAND = "Advance";

    private static String TRAIN_COMMAND = "Train";

    private static String OVER_COMMAND = "Quit";


    public static void main(String[] args) throws IOException {
        InputReader reader = new ConsoleReader();
        OutputWriter writer = new ConsoleWriter();

        DungeonManager manager = new DungeonManagerImpl();

        while (true){
            List<String> arguments = Arrays.stream(reader.readLine().split(COMMAND_SPLITTER)).collect(Collectors.toList());

            executeCommand(manager, arguments, writer);

            if (OVER_COMMAND.equals(arguments.get(0))){
                break;
            }
        }
    }

    private static void executeCommand(DungeonManager manager, List<String> arguments, OutputWriter writer) {
        List<String> args = arguments.stream().skip(1).collect(Collectors.toList());

        switch (arguments.get(0)){
            case "Hero":
                writer.println(manager.hero(args));
                break;
            case "Select":
                writer.println(manager.select(args));
                break;
            case "Status":
                writer.println(manager.status(args));
                break;
            case "Fight":
                writer.println(manager.fight(args));
                break;
            case "Advance":
                writer.println(manager.advance(args));
                break;
            case "Train":
                writer.println(manager.train(args));
                break;
            case "Quit":
                writer.println(manager.quit(args));
                break;
        }
    }
}
